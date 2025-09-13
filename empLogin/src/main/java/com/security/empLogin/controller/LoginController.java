package com.security.empLogin.controller;

import com.security.empLogin.entity.LoginEntity;
import com.security.empLogin.model.LoginPojo;
import com.security.empLogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("user")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/signup")
    public String addUser(@RequestBody LoginPojo loginPojo) throws RuntimeException {
        loginService.addUser(loginPojo);
        return "User added successfully";
    }

    @GetMapping("/getAllUsers")
    public List<LoginEntity> getAllUsers() throws RuntimeException {
        return loginService.getAllUsers();
    }

}
