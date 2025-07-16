package com.microservice.jobService.controller;

import com.microservice.jobService.dto.JobRequestDTO;
import com.microservice.jobService.dto.JobResponseDTO;
import com.microservice.jobService.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class JobController {

    private final JobService jobService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<JobResponseDTO> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobResponseDTO createJob(@RequestBody JobRequestDTO job){
        return jobService.createJob(job);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JobResponseDTO updateJob(@PathVariable Long id, @RequestBody JobRequestDTO jobRequestDTO) {
        return jobService.updateJobByID(id, jobRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }


}
