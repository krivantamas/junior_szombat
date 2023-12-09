package org.webler.zsolt.blog.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webler.zsolt.blog.model.Post;
import org.webler.zsolt.blog.repository.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public Post addPost(@RequestBody @Valid Post post) {
        return postRepository.save(post);
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
        Post updatableUser = postRepository.findById(post.getId()).orElseThrow();
        updatableUser.setContent(post.getContent());
        updatableUser.setStatus(post.getStatus());
        updatableUser.setTitle(post.getTitle());

        return postRepository.save(updatableUser);
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
