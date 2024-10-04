package com.sahha.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@RestController
@RequestMapping("/public/api/v1/biomarkers")
public class BiomarkersController {

    WebClient client1 = WebClient.builder()
            .baseUrl("https://sandbox-api.sahha.ai")
            .build();
    private static String externalId = "4B06C59F-A3AE-42AE-A178-E32A6F061B18";
    private static String accountsToken ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwczovL2FwaS5zYWhoYS5haS9jbGFpbXMvYWNjb3VudElkIjoiOTk2NzE2ZmMtNDUzMC00MjJkLTg4OWYtOTljZDEzY2IxYjJmIiwiaHR0cHM6Ly9hcGkuc2FoaGEuYWkvY2xhaW1zL2FkbWluIjoiVHJ1ZSIsImh0dHBzOi8vYXBpLnNhaGhhLmFpL2NsYWltcy9hY2NvdW50IjoiVHJ1ZSIsImh0dHBzOi8vYXBpLnNhaGhhLmFpL2NsYWltcy9zYWhoYUFwaVNjb3BlIjoiU2FuZGJveCIsImV4cCI6MTczMDA3NzUzMCwiaXNzIjoiaHR0cHM6Ly9zYWhoYS1wcm9kdWN0aW9uLmF1LmF1dGgwLmNvbS8iLCJhdWQiOiJodHRwczovL3NhaGhhLXByb2R1Y3Rpb24uYXUuYXV0aDAuY29tL2FwaS92Mi8ifQ.M6xh1HNQ91fQfdwKEeBHpwZHrSsPPEz-oq6FynzgcUI";
    private static String profilesToken = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwczovL2FwaS5zYWhoYS5haS9jbGFpbXMvcHJvZmlsZUlkIjoiNjU2OTFkOWQtMGNhYi00MzY1LTg1MDMtYzY3MmU3YTI5ZDgwIiwiaHR0cHM6Ly9hcGkuc2FoaGEuYWkvY2xhaW1zL2V4dGVybmFsSWQiOiI0QjA2QzU5Ri1BM0FFLTQyQUUtQTE3OC1FMzJBNkYwNjFCMTgiLCJodHRwczovL2FwaS5zYWhoYS5haS9jbGFpbXMvYWNjb3VudElkIjoiOTk2NzE2ZmMtNDUzMC00MjJkLTg4OWYtOTljZDEzY2IxYjJmIiwiaHR0cHM6Ly9hcGkuc2FoaGEuYWkvY2xhaW1zL3NhaGhhQXBpU2NvcGUiOiJTYW5kYm94IiwiZXhwIjoxNzMwNTU1MjQ0LCJpc3MiOiJodHRwczovL3NhbmRib3gtYXBpLnNhaGhhLmFpIiwiYXVkIjoiaHR0cHM6Ly9zYW5kYm94LWFwaS5zYWhoYS5haSJ9.sKyoaneJyc2mzeNqx5YN2q2mhHEdAEf8nViq-vl9REc";
    @GetMapping("/steps")
    public ArrayList<Map<String,Object>> getBioMarkers(){
        ArrayList<Map<String,Object>> biomarkers = client1.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/profile/biomarker/"+externalId)
                        .queryParam("types", List.of("steps"))
                        .build())
                .header("Authorization", "account " + accountsToken)
                .retrieve()
                .bodyToMono(ArrayList.class)
                .block();
        return biomarkers;
    }

    @PostMapping("/profile")
    public Map<String,Object> getProfileToken(){
        Map<String,String> bodyValues = new HashMap<>();
        bodyValues.put("externalId",externalId);
        Map<String,Object> profileToken = client1.post()
                .uri("/api/v1/oauth/profile/token")
                .bodyValue(bodyValues)
                .header("Authorization", "profile " + accountsToken)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return profileToken;
    }

    @GetMapping("/profile/biomarker")
    public Map<String,Object> getProfileBiomarker(){
        Map<String,Object> profileBiomarker= client1.get()
                .uri(uriBuilder -> uriBuilder
                        .path("api/v1/profile/biomarker")
                        .queryParam("types", "height")
                        .build())
                .header("Authorization", "profile " + profilesToken)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return profileBiomarker;
    }
}