package com.sahha.app.service;

import com.sahha.app.config.AccountToken;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Map;

@Service
public class HealthScoreService {

    AccountToken accountToken;

    public HealthScoreService(AccountToken accountToken) {
        this.accountToken = accountToken;
    }

    WebClient client1 = WebClient.builder()
            .baseUrl("https://sandbox-api.sahha.ai")
            .build();

    public ArrayList<Map<String, Object>> getHealthScoreService(String externalId,
                                                                String scores) {
        ArrayList<Map<String, Object>> scorelist = client1.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/profile/score/" + externalId)
                        .queryParam("types", scores)
                        .build())
                .header("Authorization", "account " + accountToken.getAccountToken())
                .retrieve()
                .bodyToMono(ArrayList.class)
                .block();
        return scorelist;
    }
}