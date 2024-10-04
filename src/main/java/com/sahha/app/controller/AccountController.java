package com.sahha.app.controller;

import com.sahha.app.config.AccountToken;
import com.sahha.app.service.AccountSerivce;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/public/api/v1/account")
public class AccountController {

    AccountSerivce accountSerivce;

    public AccountController(AccountSerivce accountSerivce) {
        this.accountSerivce = accountSerivce;
    }



    @GetMapping("/get")
    public String getAccountsToken(){
        return accountSerivce.getAccountsTokenService();
    }
}