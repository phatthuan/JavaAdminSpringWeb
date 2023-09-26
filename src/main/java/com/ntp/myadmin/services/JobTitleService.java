package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.JobTitle;
import com.ntp.myadmin.repositories.JobTitleRepository;



@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    public Optional<JobTitle> findById(Integer id){
        return jobTitleRepository.findById(id);
    }

    public void delete(Integer id){
        jobTitleRepository.deleteById(id);
    }
}
