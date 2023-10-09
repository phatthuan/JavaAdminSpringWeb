package com.ntp.myadmin.controllers;

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

import com.ntp.myadmin.models.Employee;
import com.ntp.myadmin.services.CountryService;
import com.ntp.myadmin.services.EmployeeService;
import com.ntp.myadmin.services.EmployeeTypeService;
import com.ntp.myadmin.services.JobTitleService;
import com.ntp.myadmin.services.StateService;

@Controller
public class EmployeeController {
    @Autowired private EmployeeService employeeService;
	@Autowired private StateService stateService;
	
	@Autowired private JobTitleService jobTitleService;
	
	@Autowired private EmployeeTypeService employeeTypeService;
	@Autowired private CountryService countryService;
	
	//Get All Employees
	@GetMapping("employees")
	public String findAll(Model model){
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());		
		model.addAttribute("employees", employeeService.getEmployees());
		return "employee";
	}	
	
	@RequestMapping("employees/findById/{id}") 
	@ResponseBody
	public Optional<Employee> findById(@PathVariable Integer id)
	{
		return employeeService.findById(id);
	}
	
	//Add Employee
	@PostMapping(value="employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}	
	
	@RequestMapping(value="employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);	
		return "redirect:/employees";
	}
	
	@RequestMapping(value="employees/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}	
}
