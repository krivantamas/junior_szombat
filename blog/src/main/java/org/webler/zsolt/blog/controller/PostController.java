package org.webler.zsolt.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.webler.zsolt.blog.controller.dto.AddCommentRequest;
import org.webler.zsolt.blog.controller.dto.CreatePostRequest;
import org.webler.zsolt.blog.controller.dto.UpdateCommentRequest;
import org.webler.zsolt.blog.model.Comment;
import org.webler.zsolt.blog.model.Post;
import org.webler.zsolt.blog.model.User;
import org.webler.zsolt.blog.repository.CommentRepository;
import org.webler.zsolt.blog.repository.PostRepository;
import org.webler.zsolt.blog.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;

    @Autowired
    private ObjectMapper jacksonMapper;

    @Autowired
    public PostController(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @PostMapping
    public Post addPost(@RequestBody @Valid CreatePostRequest request, Principal principal) {
        User author = userRepository.findByUsername(principal.getName()).get();
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        postRepository.save(post);
        author.addPost(post);
        userRepository.saveAndFlush(author);

        return post;
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity addComment(@PathVariable Long id, @RequestBody @Valid AddCommentRequest request, Principal principal) throws JsonProcessingException {

        try {
            Post post = postRepository.findById(id).orElseThrow();

            post.addComment(Comment.builder()
                    .author(userRepository.findByUsername(principal.getName()).get())
                    .content(request.getContent())
                    .build());

            postRepository.save(post);

            return new ResponseEntity<>(jacksonMapper.writeValueAsString(post), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{postId}/comments/{commentId}")
    public ResponseEntity updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody @Valid UpdateCommentRequest request, Principal principal) throws JsonProcessingException {
        try {
            Comment comment = commentRepository.findByPost_IdAndId(postId, commentId).orElseThrow();
            assertAuthorIsCurrentUser(comment.getAuthor(), userRepository.findByUsername(principal.getName()).get());
            comment.setContent(request.getContent());
            commentRepository.save(comment);

            return new ResponseEntity<>(jacksonMapper.writeValueAsString(comment), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>(jacksonMapper.writeValueAsString(e.getMessage()), HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody @Valid UpdateCommentRequest request, Principal principal) throws JsonProcessingException, ExecutionControl.NotImplementedException {
        //TODO HÁZI

        throw new ExecutionControl.NotImplementedException("Not implemented!");
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getComments(@PathVariable Long id) {

        return commentRepository.findAllByPost_Id(id);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PatchMapping
    public Post updatePost(@RequestBody @Valid Post post) {
        //TODO HÁZI
        return null;
    }

    @DeleteMapping
    public void deleteAllPost() {
        postRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePostById(@PathVariable Long id, Authentication authentication) throws JsonProcessingException {


        List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        if (authorities.contains("ADMIN")) {
            postRepository.deleteById(id);
        } else {

            try {
                Post post = postRepository.findById(id).orElseThrow();
                assertAuthorIsCurrentUser(post.getAuthor(), userRepository.findByUsername(authentication.getName()).get());
                postRepository.deleteById(id);

            } catch (Exception e) {
                return new ResponseEntity<>(jacksonMapper.writeValueAsString(e.getMessage()), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity(HttpStatus.OK);

    }


    private void assertAuthorIsCurrentUser(User author, User currentUser) {

        if (!author.equals(currentUser)) {
            throw new RuntimeException("Permission denied!");
        }
    }

}
