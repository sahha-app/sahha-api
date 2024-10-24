package com.sahha.app.controller;


import com.sahha.app.model.User;
import com.sahha.app.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-up")
public class RegistrationController {

    UserService userService;
    PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public void createUser (User user){
        String userEncodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(userEncodedPassword);
        userService.createUser(user);
    }
}