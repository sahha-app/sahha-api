package com.sahha.app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountToken {

    private String accountToken;

    public AccountToken() {

    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }


    public String getAccountToken() {
        return accountToken;
    }
}