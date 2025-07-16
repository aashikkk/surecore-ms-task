package com.microservice.applicationService.repository;

import com.microservice.applicationService.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
