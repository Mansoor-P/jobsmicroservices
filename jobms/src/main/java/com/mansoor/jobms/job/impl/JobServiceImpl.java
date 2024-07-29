package com.mansoor.jobms.job.impl;


import com.mansoor.jobms.job.Job;
import com.mansoor.jobms.job.JobRepository;
import com.mansoor.jobms.job.JobService;
import com.mansoor.jobms.job.dto.JobWithCompanyDTO;
import com.mansoor.jobms.job.external.Company;
import com.mansoor.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    @Autowired
    public RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithCompanyDTO> findAll() {

        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();


        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobWithCompanyDTO convertToDto(Job job) {
        Company company = restTemplate.getForObject("http://COMPANY-SERVICE:8081/api/v1/companies/" + job.getCompanyId(), Company.class);
        JobWithCompanyDTO jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDto(job, company);
        jobWithCompanyDTO.setCompany(company);
        return jobWithCompanyDTO;

    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }


    @Override
    public JobWithCompanyDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
