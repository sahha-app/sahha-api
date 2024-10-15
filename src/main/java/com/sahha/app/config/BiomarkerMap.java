package com.sahha.app.config;

import com.sahha.app.constant.BiomarkerConstant;
import com.sahha.app.dto.BiomarkerDTO;
import com.sahha.app.dto.CategoryDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sahha.app.constant.BiomarkerConstant.*;

@Configuration
public class BiomarkerMap {

    private static final Map<String, String> biomarkerMap = new HashMap<>();
    private static final List<CategoryDTO> biomarkerCategories = new ArrayList<>();


    public BiomarkerMap() {
        biomarkerMap.put(STEPS, ACTIVITY);
        biomarkerMap.put(FLOORS_CLIMBED, ACTIVITY);
        biomarkerMap.put(ACTIVE_HOURS, ACTIVITY);
        biomarkerMap.put(ACTIVE_DURATION, ACTIVITY);
        biomarkerMap.put(ACTIVITY_LOW_INTENSITY_DURATION, ACTIVITY);
        biomarkerMap.put(ACTIVITY_MEDIUM_INTENSITY_DURATION, ACTIVITY);
        biomarkerMap.put(ACTIVITY_HIGH_INTENSITY_DURATION, ACTIVITY);
        biomarkerMap.put(ACTIVITY_SEDENTARY_DURATION, ACTIVITY);
        biomarkerMap.put(ACTIVE_ENERGY_BURNED, ACTIVITY);
        biomarkerMap.put(TOTAL_ENERGY_BURNED, ACTIVITY);
        biomarkerMap.put(HEIGHT, BODY);
        biomarkerMap.put(WEIGHT, BODY);
        biomarkerMap.put(BODY_MASS_INDEX, BODY);
        biomarkerMap.put(BODY_FAT, BODY);
        biomarkerMap.put(FAT_MASS, BODY);
        biomarkerMap.put(LEAN_MASS, BODY);
        biomarkerMap.put(WAIST_CIRCUMFERENCE, BODY);
        biomarkerMap.put(RESTING_ENERGY_BURNED, BODY);
        biomarkerMap.put(MENSTRUAL_CYCLE_START_DATE, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_CYCLE_END_DATE, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_CYCLE_LENGTH, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_CYCLE_DAY_NUMBER, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_PHASE, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_PHASE_START_DATE, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_PHASE_END_DATE, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_PHASE_LENGTH, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_PHASE_DAY_NUMBER, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUAL_PHASE_DAYS_TO_NEXT_PHASE, REPRODUCTIVE);
        biomarkerMap.put(FERTILE_WINDOW_START_DATE, REPRODUCTIVE);
        biomarkerMap.put(FERTILE_WINDOW_END_DATE, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUATION_PERIOD_START_DATE, REPRODUCTIVE);
        biomarkerMap.put(MENSTRUATION_PERIOD_END_DATE, REPRODUCTIVE);
        biomarkerMap.put(SLEEP_START_TIME, SLEEP);
        biomarkerMap.put(SLEEP_MID_TIME, SLEEP);
        biomarkerMap.put(SLEEP_END_TIME, SLEEP);
        biomarkerMap.put(SLEEP_DURATION, SLEEP);
        biomarkerMap.put(SLEEP_DEBT, SLEEP);
        biomarkerMap.put(SLEEP_INTERRUPTIONS, SLEEP);
        biomarkerMap.put(SLEEP_IN_BED_DURATION, SLEEP);
        biomarkerMap.put(SLEEP_AWAKE_DURATION, SLEEP);
        biomarkerMap.put(SLEEP_LIGHT_DURATION, SLEEP);
        biomarkerMap.put(SLEEP_REM_DURATION, SLEEP);
        biomarkerMap.put(SLEEP_DEEP_DURATION, SLEEP);
        biomarkerMap.put(SLEEP_REGULARITY, SLEEP);
        biomarkerMap.put(SLEEP_LATENCY, SLEEP);
        biomarkerMap.put(SLEEP_EFFICIENCY, SLEEP);
        biomarkerMap.put(HEART_RATE_RESTING, VITALS);
        biomarkerMap.put(HEART_RATE_SLEEP, VITALS);
        biomarkerMap.put(HEART_RATE_VARIABILITY_SDNN, VITALS);
        biomarkerMap.put(HEART_RATE_VARIABILITY_RMSSD, VITALS);
        biomarkerMap.put(RESPIRATORY_RATE, VITALS);
        biomarkerMap.put(RESPIRATORY_RATE_SLEEP, VITALS);
        biomarkerMap.put(OXYGEN_SATURATION, VITALS);
        biomarkerMap.put(OXYGEN_SATURATION_SLEEP, VITALS);
        biomarkerMap.put(VO2_MAX, VITALS);
        biomarkerMap.put(BLOOD_GLUCOSE, VITALS);
        biomarkerMap.put(BLOOD_PRESSURE_SYSTOLIC, VITALS);
        biomarkerMap.put(BLOOD_PRESSURE_DIASTOLIC, VITALS);
        biomarkerMap.put(BODY_TEMPERATURE_BASAL, VITALS);
        biomarkerMap.put(SKIN_TEMPERATURE_SLEEP, VITALS);

//        construct the list of biomarker categories
        biomarkerCategories.add(new CategoryDTO(ACTIVITY, List.of(
                new BiomarkerDTO(STEPS),
                new BiomarkerDTO(FLOORS_CLIMBED),
                new BiomarkerDTO(ACTIVE_HOURS),
                new BiomarkerDTO(ACTIVE_DURATION),
                new BiomarkerDTO(ACTIVITY_LOW_INTENSITY_DURATION),
                new BiomarkerDTO(ACTIVITY_HIGH_INTENSITY_DURATION),
                new BiomarkerDTO(ACTIVITY_MEDIUM_INTENSITY_DURATION),
                new BiomarkerDTO(ACTIVITY_SEDENTARY_DURATION),
                new BiomarkerDTO(ACTIVE_ENERGY_BURNED),
                new BiomarkerDTO(TOTAL_ENERGY_BURNED)
        )));
        biomarkerCategories.add(new CategoryDTO(BODY, List.of(
                new BiomarkerDTO(HEIGHT),
                new BiomarkerDTO(WEIGHT),
                new BiomarkerDTO(BODY_MASS_INDEX),
                new BiomarkerDTO(BODY_FAT),
                new BiomarkerDTO(FAT_MASS),
                new BiomarkerDTO(LEAN_MASS),
                new BiomarkerDTO(WAIST_CIRCUMFERENCE),
                new BiomarkerDTO(RESTING_ENERGY_BURNED)
        )));
        biomarkerCategories.add(new CategoryDTO(REPRODUCTIVE, List.of(
                new BiomarkerDTO(MENSTRUAL_CYCLE_START_DATE),
                new BiomarkerDTO(MENSTRUAL_CYCLE_END_DATE),
                new BiomarkerDTO(MENSTRUAL_CYCLE_LENGTH),
                new BiomarkerDTO(MENSTRUAL_PHASE_DAY_NUMBER),
                new BiomarkerDTO(MENSTRUAL_PHASE),
                new BiomarkerDTO(MENSTRUAL_CYCLE_START_DATE),
                new BiomarkerDTO(MENSTRUAL_PHASE_END_DATE),
                new BiomarkerDTO(MENSTRUAL_PHASE_LENGTH),
                new BiomarkerDTO(MENSTRUAL_PHASE_DAY_NUMBER),
                new BiomarkerDTO(MENSTRUAL_PHASE_DAYS_TO_NEXT_PHASE),
                new BiomarkerDTO(FERTILE_WINDOW_START_DATE),
                new BiomarkerDTO(FERTILE_WINDOW_END_DATE),
                new BiomarkerDTO(MENSTRUATION_PERIOD_START_DATE),
                new BiomarkerDTO(MENSTRUATION_PERIOD_END_DATE)

        )));
        biomarkerCategories.add(new CategoryDTO(SLEEP, List.of(
                new BiomarkerDTO(SLEEP_START_TIME),
                new BiomarkerDTO(SLEEP_END_TIME),
                new BiomarkerDTO(SLEEP_MID_TIME),
                new BiomarkerDTO(SLEEP_DURATION),
                new BiomarkerDTO(SLEEP_DEBT),
                new BiomarkerDTO(SLEEP_INTERRUPTIONS),
                new BiomarkerDTO(SLEEP_IN_BED_DURATION),
                new BiomarkerDTO(SLEEP_AWAKE_DURATION),
                new BiomarkerDTO(SLEEP_LIGHT_DURATION),
                new BiomarkerDTO(SLEEP_REM_DURATION),
                new BiomarkerDTO(SLEEP_DEEP_DURATION),
                new BiomarkerDTO(SLEEP_REGULARITY),
                new BiomarkerDTO(SLEEP_LATENCY),
                new BiomarkerDTO(SLEEP_EFFICIENCY)
        )));
        biomarkerCategories.add(new CategoryDTO(VITALS, List.of(
                new BiomarkerDTO(HEART_RATE_RESTING),
                new BiomarkerDTO(HEART_RATE_SLEEP),
                new BiomarkerDTO(HEART_RATE_VARIABILITY_SDNN),
                new BiomarkerDTO(HEART_RATE_VARIABILITY_RMSSD),
                new BiomarkerDTO(RESPIRATORY_RATE),
                new BiomarkerDTO(RESPIRATORY_RATE_SLEEP),
                new BiomarkerDTO(OXYGEN_SATURATION),
                new BiomarkerDTO(OXYGEN_SATURATION_SLEEP),
                new BiomarkerDTO(VO2_MAX),
                new BiomarkerDTO(BLOOD_GLUCOSE),
                new BiomarkerDTO(BLOOD_PRESSURE_SYSTOLIC),
                new BiomarkerDTO(BLOOD_PRESSURE_DIASTOLIC),
                new BiomarkerDTO(BODY_TEMPERATURE_BASAL),
                new BiomarkerDTO(SKIN_TEMPERATURE_SLEEP)
        )));

    }

    @Bean
    public static List<CategoryDTO> listBiomarkerCategories() {
        return biomarkerCategories;

    }

    @Bean
    public static Map<String, String> getBiomarkerMap() {
        return biomarkerMap;
    }
}