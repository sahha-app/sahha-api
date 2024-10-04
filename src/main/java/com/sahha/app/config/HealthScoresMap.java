package com.sahha.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.sahha.app.constant.BiomarkerConstant.*;
import static com.sahha.app.constant.BiomarkerConstant.VITALS;
import static com.sahha.app.constant.HealthScoresConstant.*;
import static com.sahha.app.constant.HealthScoresConstant.ACTIVITY;
import static com.sahha.app.constant.HealthScoresConstant.SLEEP;

public class HealthScoresMap {
    private static final Map<String, String> healthScoresMap = new HashMap<>();

    public HealthScoresMap() {
        healthScoresMap.put(WELLBEING, WELLBEING);
        healthScoresMap.put(ACTIVITY, ACTIVITY);
        healthScoresMap.put(SLEEP, SLEEP);
        healthScoresMap.put(MENTAL_WELLBEING, MENTAL_WELLBEING);
        healthScoresMap.put(READINESS, READINESS);
        healthScoresMap.put(DEPRESSION, DEPRESSION);
        healthScoresMap.put(STRESS, STRESS);
        healthScoresMap.put(ANXIETY, ANXIETY);

    }

    @Bean
    public static Map<String, String> getHealthScoresMap() {
        return healthScoresMap;
    }
}
