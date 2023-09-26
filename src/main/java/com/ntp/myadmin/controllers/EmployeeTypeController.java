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

import com.ntp.myadmin.models.EmployeeType;
import com.ntp.myadmin.services.EmployeeTypeService;



@Controller
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String getemployeetypes(Model model){
        List<EmployeeType> EmployeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeetypes", EmployeeTypeList);
        return "employeetype";
    }

    @RequestMapping("/employeeTypes/findById/{id}")
    @ResponseBody
    public Optional<EmployeeType> findById(@PathVariable Integer id){
        return employeeTypeService.findById(id);
    }

    @PostMapping("/employeeTypes/addNew")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "employeeTypes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
