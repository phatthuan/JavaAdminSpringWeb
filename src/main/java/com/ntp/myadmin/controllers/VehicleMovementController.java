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

import com.ntp.myadmin.models.VehicleMovement;
import com.ntp.myadmin.services.LocationService;
import com.ntp.myadmin.services.VehicleMovementService;
import com.ntp.myadmin.services.VehicleService;

@Controller
public class VehicleMovementController {
    @Autowired private VehicleMovementService vehicleMovementService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleService vehicleService;
	
	//Get All VehicleMovements
	@GetMapping("vehicleMovements")
	public String findAll(Model model){		
		model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("vehicles", vehicleService.getVehicles());

		return "vehiclemovement";
	}	
	
	@RequestMapping("vehicleMovements/findById/{id}") 
	@ResponseBody
	public Optional<VehicleMovement> findById(@PathVariable Integer id)
	{
		return vehicleMovementService.findById(id);
	}
	
	//Add VehicleMovement
	@PostMapping(value="vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}	
	
	@RequestMapping(value="vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping(value="vehicleMovements/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}
}
