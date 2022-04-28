package com.cachingtut.learningcaching.controller;

import com.cachingtut.learningcaching.model.User;
import com.cachingtut.learningcaching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("Request received to the controller");
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        System.out.println("Request received to the controller");
        return userService.searchUser(id);
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        System.out.println("Request received to the controller");
        return userService.addNewUser(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public boolean removeUser(@PathVariable int id) {
        System.out.println("Request received to the controller");
        return userService.removeUser(id);
    }
}