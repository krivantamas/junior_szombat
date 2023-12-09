package org.webler.zsolt.blog.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webler.zsolt.blog.model.Post;
import org.webler.zsolt.blog.model.User;
import org.webler.zsolt.blog.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User addUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @PostMapping("/{id}/posts")
    public Post postForUser(@PathVariable Long id, @RequestBody @Valid Post post) {
        User user = userRepository.findById(id).orElseThrow();
        user.addPost(post);
        userRepository.saveAndFlush(user);
        return post;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @GetMapping
    public List<User> getAllUsers(Principal principal) {



        return userRepository.findAll();
    }

    @PatchMapping
    public User updateUser(@RequestBody @Valid User user) {
        User updatableUser = userRepository.findById(user.getId()).orElseThrow();
        updatableUser.setEmail(user.getEmail());
        updatableUser.setPassword(user.getPassword());
        updatableUser.setUsername(user.getUsername());

        return userRepository.save(updatableUser);
    }

    @DeleteMapping
    public void deleteAllUser() {
        userRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }


}
