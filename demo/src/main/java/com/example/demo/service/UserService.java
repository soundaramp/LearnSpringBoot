package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    userRepo userrepo;
    public User addUser(User user) {
        return userrepo.save(user);
    }
    public List<User> getAllUsers() {
        return userrepo.findAll();
    }
}
