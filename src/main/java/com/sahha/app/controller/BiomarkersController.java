package com.sahha.app.controller;

import com.sahha.app.service.BiomarkerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


import java.util.*;

import static com.sahha.app.constant.SwaggerConstant.CONTROLLER_DESCRIPTION;
import static com.sahha.app.constant.SwaggerConstant.CONTROLLER_NAME;

@RestController
@RequestMapping("/public/api/v1/biomarkers")
@Tag(name = CONTROLLER_NAME, description = CONTROLLER_DESCRIPTION)
public class BiomarkersController {

    BiomarkerService biomarkerService;

    public BiomarkersController(BiomarkerService biomarkerService) {
        this.biomarkerService = biomarkerService;
    }


    @GetMapping("/get/{externalId}")
    public ArrayList<Map<String,Object>> getBioMarkers(@PathVariable String externalId
    ,@RequestParam (required = false) String biomarker){
        return biomarkerService.getBioMarkersService(externalId, biomarker);
    }
}