package com.security.empLogin.service;

import com.security.empLogin.entity.LoginEntity;
import com.security.empLogin.model.LoginPojo;
import com.security.empLogin.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoginService {//implements UserDetailsService {
    @Autowired
    LoginRepo loginRepo;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws RuntimeException {
//        Optional<LoginEntity> opt = loginRepo.findByUsername(username);
//        if (opt.isPresent()) {
//            LoginEntity loginEntity = opt.get();
//            return User.withUsername(loginEntity.getUsername()).password(loginEntity.getPassword()).roles(loginEntity.getRole()).build();
//        }
//        throw new RuntimeException("Invalid username or password");
//    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void addUser(LoginPojo loginPojo) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setPassword(passwordEncoder.encode(loginPojo.password()));
        loginEntity.setUsername(loginPojo.username());
        loginRepo.save(loginEntity);
    }

    public List<LoginEntity> getAllUsers() {
        return loginRepo.findAll();
    }
}
