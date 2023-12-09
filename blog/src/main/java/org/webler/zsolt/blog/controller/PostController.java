package org.webler.zsolt.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webler.zsolt.blog.controller.dto.AddCommentRequest;
import org.webler.zsolt.blog.controller.dto.CreatePostRequest;
import org.webler.zsolt.blog.model.Comment;
import org.webler.zsolt.blog.model.Post;
import org.webler.zsolt.blog.model.User;
import org.webler.zsolt.blog.repository.PostRepository;
import org.webler.zsolt.blog.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper jacksonMapper;

    @Autowired
    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
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

    @PatchMapping()
    public ResponseEntity updateComment(@PathVariable Long id, @RequestBody @Valid AddCommentRequest request, Principal principal) throws JsonProcessingException {

        return null;
    }

    @GetMapping("/{id}/comments")
    public String getComments() {


        return "comments";
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
    public void deletePostById(@PathVariable Long id) {
        postRepository.deleteById(id);
    }


}
