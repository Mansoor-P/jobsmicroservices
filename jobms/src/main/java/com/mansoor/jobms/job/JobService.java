package com.mansoor.jobms.job;

import com.mansoor.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
    void createJob(Job job);

    List<JobWithCompanyDTO> findAll();

    JobWithCompanyDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

}
