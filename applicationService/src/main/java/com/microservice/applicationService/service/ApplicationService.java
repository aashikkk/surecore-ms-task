package com.microservice.applicationService.service;

import com.microservice.applicationService.model.Application;
import com.microservice.applicationService.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public Application submitApplication(Application application) {
        // Save the application to the repository
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        // Retrieve all applications from the repository
        return applicationRepository.findAll();
    }
}
