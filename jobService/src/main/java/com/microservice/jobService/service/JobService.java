package com.microservice.jobService.service;

import com.microservice.jobService.dto.JobRequestDTO;
import com.microservice.jobService.dto.JobResponseDTO;
import com.microservice.jobService.model.Job;
import com.microservice.jobService.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private static final Logger log = LoggerFactory.getLogger(JobService.class);
    private final JobRepository jobRepository;

    public List<JobResponseDTO> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(job -> new JobResponseDTO(job.getId(), job.getTitle(), job.getDescription(), job.getCompany(), job.getLocation()))
                .toList();
    }

    public JobResponseDTO createJob(JobRequestDTO jobRequestDTO) {
        Job job = new Job();
        job.setTitle(jobRequestDTO.title());
        job.setDescription(jobRequestDTO.description());
        job.setCompany(jobRequestDTO.company());
        job.setLocation(jobRequestDTO.location());

        jobRepository.save(job);
        log.info("Job created successfully with ID: {}", job.getId());
        return new JobResponseDTO(job.getId(), job.getTitle(), job.getDescription(), job.getCompany(), job.getLocation());
    }

    public JobResponseDTO updateJobByID(Long id, JobRequestDTO jobRequestDTO) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));

        job.setTitle(jobRequestDTO.title());
        job.setDescription(jobRequestDTO.description());
        job.setCompany(jobRequestDTO.company());
        job.setLocation(jobRequestDTO.location());

        jobRepository.save(job);
        log.info("Job updated successfully with ID: {}", job.getId());
        return new JobResponseDTO(job.getId(), job.getTitle(), job.getDescription(), job.getCompany(), job.getLocation());
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
