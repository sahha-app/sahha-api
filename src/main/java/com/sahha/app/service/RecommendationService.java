package com.sahha.app.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecommendationService {

    @Value("${CLIENT_ID}")
    private String clientId;

    @Value("${CLIENT_SECRET}")
    private String clientSecret;
    WebClient client1 = WebClient.builder()
            .baseUrl("https://sandbox-api.sahha.ai")
            .build();

    public String getMLRecommendation(){
        Map<String,String> bodyValues = new HashMap<>();
        bodyValues.put("clientId",clientId);
        bodyValues.put("clientSecret",clientSecret);
        Map accountsToken = client1.post()
                .uri("/api/v1/oauth/account/token")
                .bodyValue(bodyValues)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        String returnAccountToken = (String) accountsToken.get("accountToken");
        return returnAccountToken;
    }
}
