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

import com.ntp.myadmin.models.VehicleHire;
import com.ntp.myadmin.services.ClientService;
import com.ntp.myadmin.services.LocationService;
import com.ntp.myadmin.services.VehicleHireService;
import com.ntp.myadmin.services.VehicleService;

@Controller
public class VehicleHireController {
    @Autowired private VehicleHireService vehicleHireService;
	@Autowired private ClientService clientService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleService vehicleService;
	
	//Get All VehicleHires
	@GetMapping("vehicleHires")
	public String findAll(Model model){		
		model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("vehicles", vehicleService.getVehicles());

		return "vehiclehire";
	}	
	
	@RequestMapping("vehicleHires/findById/{id}") 
	@ResponseBody
	public Optional<VehicleHire> findById(@PathVariable Integer id)
	{
		return vehicleHireService.findById(id);
	}
	
	//Add VehicleHire
	@PostMapping(value="vehicleHires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}	
	
	@RequestMapping(value="vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@RequestMapping(value="vehicleHires/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHires";
	}
}
