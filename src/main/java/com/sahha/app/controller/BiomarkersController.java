package com.sahha.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/public/api/v1/biomarkers")
public class BiomarkersController {

    WebClient client1 = WebClient.builder()
            .baseUrl("https://sandbox-api.sahha.ai")
            .build();
    private static String externalId = "4B06C59F-A3AE-42AE-A178-E32A6F061B18";
    private static String accountsToken ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwczovL2FwaS5zYWhoYS5haS9jbGFpbXMvYWNjb3VudElkIjoiOTk2NzE2ZmMtNDUzMC00MjJkLTg4OWYtOTljZDEzY2IxYjJmIiwiaHR0cHM6Ly9hcGkuc2FoaGEuYWkvY2xhaW1zL2FkbWluIjoiVHJ1ZSIsImh0dHBzOi8vYXBpLnNhaGhhLmFpL2NsYWltcy9hY2NvdW50IjoiVHJ1ZSIsImh0dHBzOi8vYXBpLnNhaGhhLmFpL2NsYWltcy9zYWhoYUFwaVNjb3BlIjoiU2FuZGJveCIsImV4cCI6MTczMDA0MTI2MywiaXNzIjoiaHR0cHM6Ly9zYWhoYS1wcm9kdWN0aW9uLmF1LmF1dGgwLmNvbS8iLCJhdWQiOiJodHRwczovL3NhaGhhLXByb2R1Y3Rpb24uYXUuYXV0aDAuY29tL2FwaS92Mi8ifQ.fC536zQCDwIyqAObFGwj6Jk5iIdPsXNPr8NPFp6qOfg";
    @PostMapping("/get")
    public ArrayList getBioMarkers(){
        ArrayList biomarkers = client1.get()
                .uri("/api/v1/profile/biomarker/"+externalId)
                .header("Authorizations",accountsToken)
                .retrieve()
                .bodyToMono(ArrayList.class)
                .block();
        return biomarkers;
    }
}