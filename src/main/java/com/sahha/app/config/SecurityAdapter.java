package com.sahha.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableWebSecurity
@EnableRedisHttpSession
public class SecurityAdapter {

    LoginFilter loginFilter;

    public SecurityAdapter(LoginFilter loginFilter) {
        this.loginFilter = loginFilter;
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/login", "/sign-up")
                );
        http.cors(AbstractHttpConfigurer::disable);
        http
                .authorizeRequests(a -> a
                        .requestMatchers("/login","/error","/sign-up").permitAll()
                       .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login(Customizer.withDefaults())
                .addFilterBefore(loginFilter,AuthorizationFilter.class)
                .sessionManagement(a->a.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true));

        return http.build();
    }


}