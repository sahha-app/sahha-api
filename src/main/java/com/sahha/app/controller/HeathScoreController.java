package com.sahha.app.controller;

import com.sahha.app.service.HealthScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/public/api/v1/healthscore")
public class HeathScoreController {

    HealthScoreService healthScoreService;

    public HeathScoreController(HealthScoreService healthScoreService) {
        this.healthScoreService = healthScoreService;
    }

    @GetMapping("/get/{externalId}")
    public ArrayList<Map<String,Object>> getHealthScore(@PathVariable String externalId,
                                                        @RequestParam(required = false) String scores){
        return healthScoreService.getHealthScoreService(externalId,scores) ;
    }
}