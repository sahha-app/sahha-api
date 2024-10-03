package com.sahha.app.controller;

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

    @Value("${CLIENT_ID}")
    private String clientId;

    @Value("${CLIENT_SECRET}")
    private String clientSecret;

    WebClient client1 = WebClient.builder()
            .baseUrl("https://sandbox-api.sahha.ai")
            .build();

    @GetMapping("/get")
    public String getAccountToken(){
        Map<String,String> bodyValues = new HashMap<>();
        bodyValues.put("clientId",clientId);
        bodyValues.put("clientSecret",clientSecret);
        Map accountToken = client1.post()
                .uri("/api/v1/oauth/account/token")
                .bodyValue(bodyValues)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return (String) accountToken.get("accountToken");
    }
}