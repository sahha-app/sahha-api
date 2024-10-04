package com.sahha.app.service;

import com.sahha.app.config.AccountToken;
import com.sahha.app.config.BiomarkerMap;
import com.sahha.app.config.HealthScoresMap;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Map;


@Service
public class HealthScoresService {

    private final AccountToken accountToken;

    public HealthScoresService(AccountToken accountToken) {
        this.accountToken = accountToken;
    }

    WebClient client1 = WebClient.builder()
            .baseUrl("https://sandbox-api.sahha.ai")
            .build();

    public ArrayList<Map<String, Object>> getHealthScores(String externalId,
                                                               String type) {
        ArrayList<Map<String, Object>> biomarkers = client1.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/profile/score/" + externalId)
                        .queryParam("types", HealthScoresMap.getHealthScoresMap().get(type))
                        .build())
                .header("Authorization", "account " + accountToken.getAccountToken())
                .retrieve()
                .bodyToMono(ArrayList.class)
                .block();
        return biomarkers;
    }

}
