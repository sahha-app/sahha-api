package com.sahha.app.controller;

import com.sahha.app.config.AccountToken;
import com.sahha.app.config.BiomarkerMap;
import com.sahha.app.service.BiomarkerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@RestController
@RequestMapping("/public/api/v1/biomarkers")
public class BiomarkersController {

    private final BiomarkerService biomarkerService;

    public BiomarkersController(BiomarkerService biomarkerService) {
        this.biomarkerService = biomarkerService;
    }


    @GetMapping("/get/{externalId}")
    public ArrayList<Map<String, Object>> getBioMarkers(
            @PathVariable String externalId,
            @RequestParam(required = false) String biomarker) {
        return biomarkerService.getBioMarkersService(externalId, biomarker);
    }
}