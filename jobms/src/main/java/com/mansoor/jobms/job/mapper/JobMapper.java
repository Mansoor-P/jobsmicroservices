package com.mansoor.jobms.job.mapper;

import com.mansoor.jobms.job.Job;
import com.mansoor.jobms.job.dto.JobDTO;
import com.mansoor.jobms.job.external.Company;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDto(Job job, Company company) {
        JobDTO jobDTO =new JobDTO();

        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);

        return jobDTO;
    }

}
