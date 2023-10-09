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

import com.ntp.myadmin.models.Vehicle;
import com.ntp.myadmin.services.EmployeeService;
import com.ntp.myadmin.services.LocationService;
import com.ntp.myadmin.services.VehicleMakeService;
import com.ntp.myadmin.services.VehicleModelService;
import com.ntp.myadmin.services.VehicleService;
import com.ntp.myadmin.services.VehicleStatusService;
import com.ntp.myadmin.services.VehicleTypeService;

@Controller
public class VehicleController {
    @Autowired private VehicleService vehicleService;
	@Autowired private VehicleTypeService vehicleTypeService;
	@Autowired private VehicleMakeService vehicleMakeService;
	@Autowired private VehicleModelService vehicleModelService;
	@Autowired private LocationService locationService;
	@Autowired private EmployeeService employeeService ;
	@Autowired private VehicleStatusService vehicleStatusService;


	//Get All Vehicles
	@GetMapping("vehicles")
	public String findAll(Model model){		
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatus());

		return "vehicle";
	}	
	
	@RequestMapping("vehicles/findById/{id}") 
	@ResponseBody
	public Optional<Vehicle> findById(@PathVariable Integer id)
	{
		return vehicleService.findById(id);
	}
	
	//Add Vehicle
	@PostMapping(value="vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}	
	
	@RequestMapping(value="vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value="vehicles/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
}
