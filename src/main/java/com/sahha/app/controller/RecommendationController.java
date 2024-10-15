package com.sahha.app.controller;


import com.sahha.app.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api/v1/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService){
        this.recommendationService = recommendationService;
    }

    @GetMapping("/get-recommendation")
    public String getRecommendations(){
        return this.recommendationService.getMLRecommendation();
    }
}