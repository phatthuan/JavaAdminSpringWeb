package com.ntp.myadmin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ntp.myadmin.models.JobTitle;
import com.ntp.myadmin.services.JobTitleService;



@Controller
public class JobTitleController {
    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String getjobtitles(Model model){
        List<JobTitle> JobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobtitles", JobTitleList);
        return "jobtitle";
    }

    @RequestMapping("/jobTitles/findById/{id}")
    @ResponseBody
    public Optional<JobTitle> findById(@PathVariable Integer id){
        return jobTitleService.findById(id);
    }

    @PostMapping("/jobTitles/addNew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "jobTitles/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
