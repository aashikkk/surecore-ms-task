package com.microservice.jobService.dto;

public record JobRequestDTO (
    String title,
    String description,
    String company,
    String location
){
}
