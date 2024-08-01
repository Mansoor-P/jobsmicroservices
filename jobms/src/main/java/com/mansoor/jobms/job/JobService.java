package com.mansoor.jobms.job;

import com.mansoor.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
    void createJob(Job job);

    List<JobDTO> findAll();

    JobDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

}
