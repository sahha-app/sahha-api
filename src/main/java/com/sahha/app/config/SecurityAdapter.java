package com.sahha.app.config;

import com.sahha.app.filters.Authenticate;
import com.sahha.app.filters.AuthenticatePass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAdapter {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/", "/error").permitAll();
                    auth.requestMatchers("/private").authenticated();
//                    auth.requestMatchers("/favicon.ico").permitAll();
//                    auth.anyRequest().authenticated();
                })
//                .oauth2Login(withDefaults())
//                .formLogin(withDefaults())
                .addFilterBefore(new Authenticate(), AuthorizationFilter.class)
                .addFilterBefore(new AuthenticatePass(), AuthorizationFilter.class)
                .build();
    }

}