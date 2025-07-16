package com.microservice.jobService.dto;

public record JobResponseDTO (Long id,
    String title,
    String description,
    String company,
    String location
) {

}
