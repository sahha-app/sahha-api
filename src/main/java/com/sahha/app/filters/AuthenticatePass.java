package com.sahha.app.filters;

import com.sahha.app.authentications.UserAuthentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticatePass  extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        System.out.println("request.getMethod()   " + request.getMethod());
        if (request.getMethod().equalsIgnoreCase("post")) {

            UserAuthentication auth = new UserAuthentication();
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(auth);
            SecurityContextHolder.setContext(context);

            System.out.println("the authenticated user is   " + auth.getPrincipal().toString());
            System.out.println("printing from secrity context   " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());


            System.out.println("Came here applying the filter   ");
            filterChain.doFilter(request, response);
        }

    }
}
