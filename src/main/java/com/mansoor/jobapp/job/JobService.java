package com.mansoor.jobapp.job;

import java.util.List;

public interface JobService {
    void createJob(Job job);

    List<Job> findAll();

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

}
