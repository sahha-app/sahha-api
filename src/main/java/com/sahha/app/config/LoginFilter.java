package com.sahha.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahha.app.model.User;
import com.sahha.app.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


public class LoginFilter extends OncePerRequestFilter {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public LoginFilter(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // apply filter
        if (!request.getServletPath().equalsIgnoreCase("/login/basic")
                || !request.getMethod().equalsIgnoreCase("POST")){
            filterChain.doFilter(request, response);
        }
        Map<String, String> requestBody = objectMapper.readValue(request.getInputStream(), Map.class);
        String email = requestBody.get("email");
        System.out.println("this is email "+email);
        String password = requestBody.get("password");
        System.out.println("this is password "+password);

        Optional<User> optionalUser = userRepository.findByEmail(email);
        System.out.println("this is optional user  "+optionalUser);

        if (!optionalUser.isPresent()){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found");
            return;
        }
        String encodedPassword =  passwordEncoder.encode(password);
        System.out.println("this is encoded password "+encodedPassword);

        if (!optionalUser.get().getPassword().equals(encodedPassword)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);
        System.out.println("this is auth token  "+ authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }
}