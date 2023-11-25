package org.webler.zsolt.SpringTest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webler.zsolt.SpringTest.model.User;
import org.webler.zsolt.SpringTest.service.UserService;

import java.util.List;

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
    public User getUser(@PathVariable int id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
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
