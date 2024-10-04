package com.sahha.app.config;

import com.sahha.app.constant.BiomarkerConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.sahha.app.constant.BiomarkerConstant.*;

@Configuration
public class BiomarkerMap {

    private static final Map<String, String> biomarkerMap = new HashMap<>();


    public BiomarkerMap() {
        biomarkerMap.put(STEPS ,ACTIVITY );
        biomarkerMap.put(FLOORS_CLIMBED ,ACTIVITY );
        biomarkerMap.put(ACTIVE_HOURS ,ACTIVITY );
        biomarkerMap.put(ACTIVE_DURATION ,ACTIVITY );
        biomarkerMap.put(ACTIVITY_LOW_INTENSITY_DURATION ,ACTIVITY );
        biomarkerMap.put(ACTIVITY_MEDIUM_INTENSITY_DURATION ,ACTIVITY );
        biomarkerMap.put(ACTIVITY_HIGH_INTENSITY_DURATION ,ACTIVITY );
        biomarkerMap.put(ACTIVITY_SEDENTARY_DURATION ,ACTIVITY );
        biomarkerMap.put(ACTIVE_ENERGY_BURNED ,ACTIVITY );
        biomarkerMap.put(TOTAL_ENERGY_BURNED ,ACTIVITY );
        biomarkerMap.put(HEIGHT ,BODY );
        biomarkerMap.put(WEIGHT ,BODY );
        biomarkerMap.put(BODY_MASS_INDEX ,BODY );
        biomarkerMap.put(BODY_FAT ,BODY );
        biomarkerMap.put(FAT_MASS ,BODY );
        biomarkerMap.put(LEAN_MASS ,BODY );
        biomarkerMap.put(WAIST_CIRCUMFERENCE ,BODY );
        biomarkerMap.put(RESTING_ENERGY_BURNED ,BODY );
        biomarkerMap.put(MENSTRUAL_CYCLE_START_DATE ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_CYCLE_END_DATE ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_CYCLE_LENGTH ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_CYCLE_DAY_NUMBER ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_PHASE ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_PHASE_START_DATE ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_PHASE_END_DATE ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_PHASE_LENGTH ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_PHASE_DAY_NUMBER ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUAL_PHASE_DAYS_TO_NEXT_PHASE ,REPRODUCTIVE );
        biomarkerMap.put(FERTILE_WINDOW_START_DATE ,REPRODUCTIVE );
        biomarkerMap.put(FERTILE_WINDOW_END_DATE ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUATION_PERIOD_START_DATE ,REPRODUCTIVE );
        biomarkerMap.put(MENSTRUATION_PERIOD_END_DATE ,REPRODUCTIVE );
        biomarkerMap.put(SLEEP_START_TIME ,SLEEP );
        biomarkerMap.put(SLEEP_MID_TIME ,SLEEP );
        biomarkerMap.put(SLEEP_END_TIME ,SLEEP );
        biomarkerMap.put(SLEEP_DURATION ,SLEEP );
        biomarkerMap.put(SLEEP_DEBT ,SLEEP );
        biomarkerMap.put(SLEEP_INTERRUPTIONS ,SLEEP );
        biomarkerMap.put(SLEEP_IN_BED_DURATION ,SLEEP );
        biomarkerMap.put(SLEEP_AWAKE_DURATION ,SLEEP );
        biomarkerMap.put(SLEEP_LIGHT_DURATION ,SLEEP );
        biomarkerMap.put(SLEEP_REM_DURATION ,SLEEP );
        biomarkerMap.put(SLEEP_DEEP_DURATION ,SLEEP );
        biomarkerMap.put(SLEEP_REGULARITY ,SLEEP );
        biomarkerMap.put(SLEEP_LATENCY ,SLEEP );
        biomarkerMap.put(SLEEP_EFFICIENCY ,SLEEP );
        biomarkerMap.put(HEART_RATE_RESTING ,VITALS );
        biomarkerMap.put(HEART_RATE_SLEEP ,VITALS );
        biomarkerMap.put(HEART_RATE_VARIABILITY_SDNN ,VITALS );
        biomarkerMap.put(HEART_RATE_VARIABILITY_RMSSD ,VITALS );
        biomarkerMap.put(RESPIRATORY_RATE ,VITALS );
        biomarkerMap.put(RESPIRATORY_RATE_SLEEP ,VITALS );
        biomarkerMap.put(OXYGEN_SATURATION ,VITALS );
        biomarkerMap.put(OXYGEN_SATURATION_SLEEP ,VITALS );
        biomarkerMap.put(VO2_MAX ,VITALS );
        biomarkerMap.put(BLOOD_GLUCOSE ,VITALS );
        biomarkerMap.put(BLOOD_PRESSURE_SYSTOLIC ,VITALS );
        biomarkerMap.put(BLOOD_PRESSURE_DIASTOLIC ,VITALS );
        biomarkerMap.put(BODY_TEMPERATURE_BASAL ,VITALS );
        biomarkerMap.put(SKIN_TEMPERATURE_SLEEP ,VITALS );

    }

    @Bean
    public static Map<String, String> getBiomarkerMap() {
        return biomarkerMap;
    }
}