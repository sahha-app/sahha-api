package com.sahha.app.service;

import com.sahha.app.model.User;
import com.sahha.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser (User user){
        return userRepository.save(user);
    }
}