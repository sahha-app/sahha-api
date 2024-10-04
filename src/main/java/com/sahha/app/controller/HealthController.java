package com.sahha.app.controller;


import com.sahha.app.service.HealthScoresService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/public/api/v1/health-scores")
public class HealthController {

    private final HealthScoresService healthScoresService;

    public HealthController(HealthScoresService healthScoresService){
        this.healthScoresService = healthScoresService;
    }


    @GetMapping("/get/{externalId}")
    public ArrayList<Map<String, Object>> getHealthScores(
            @PathVariable String externalId,
            @RequestParam(required = false) String type) {
        return healthScoresService.getHealthScores(externalId, type);
    }
}

