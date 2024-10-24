package com.sahha.app.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/")
    public void login(Authentication authentication){
        System.out.println(authentication.getCredentials());
        System.out.println(SecurityContextHolder.getContext());

    }
}