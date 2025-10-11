package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class demoController {
    @Autowired
    UserService userservice;

    @GetMapping("/demo")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userservice.addUser(user);
    }

    @GetMapping("/getusers")
    public java.util.List<User> getAllUsers() {
        return userservice.getAllUsers();
    }
}
