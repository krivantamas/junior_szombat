package org.webler.zsolt.SpringTest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.webler.zsolt.SpringTest.model.User;
import org.webler.zsolt.SpringTest.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        try {
            return service.get(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/")
    public User findByName(@RequestParam(required = false) String name) {
        try {
            return service.findByName(name);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.remove(id);
    }

    @DeleteMapping
    public void deleteUsers() {
        service.removeAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.add(user);
    }


}
