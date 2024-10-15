package com.sahha.app.dto;

import java.util.List;

public record CategoryDTO (String categoryName, List<BiomarkerDTO> biomarkers){
}

