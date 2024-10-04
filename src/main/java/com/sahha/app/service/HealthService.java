package com.sahha.app.service;

import com.sahha.app.config.AccountToken;
import com.sahha.app.config.BiomarkerMap;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Map;


@Service
public class HealthService {

    private final AccountToken accountToken;

    public HealthService(AccountToken accountToken){
        this.accountToken = accountToken;
    }

    WebClient client1 = WebClient.builder()
            .baseUrl("https://sandbox-api.sahha.ai")
            .build();

    public ArrayList<Map<String, Object>> getBioMarkersService(String externalId
            , String biomarker) {
        ArrayList<Map<String, Object>> biomarkers = client1.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/profile/biomarker/" + externalId)
                        .queryParam("categories", BiomarkerMap.getBiomarkerMap().get(biomarker))
                        .queryParam("types", biomarker.toLowerCase())
                        .build())
                .header("Authorization", "account " + accountToken.getAccountToken())
                .retrieve()
                .bodyToMono(ArrayList.class)
                .block();
        return biomarkers;
    }

}
