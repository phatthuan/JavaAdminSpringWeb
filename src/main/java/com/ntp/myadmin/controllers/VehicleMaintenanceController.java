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

import com.ntp.myadmin.models.VehicleMaintenance;
import com.ntp.myadmin.services.SupplierService;
import com.ntp.myadmin.services.VehicleMaintenanceService;
import com.ntp.myadmin.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
    @Autowired private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired private VehicleService vehicleService;
	@Autowired private SupplierService supplierService;


	@GetMapping("vehicleMaintenances")
	public String findAll(Model model){		
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSuppliers());

		return "vehiclemaintenance";
	}	
	
	@RequestMapping("vehicleMaintenances/findById/{id}") 
	@ResponseBody
	public Optional<VehicleMaintenance> findById(@PathVariable Integer id)
	{
		return vehicleMaintenanceService.findById(id);
	}
	
	@PostMapping(value="vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}	
	
	@RequestMapping(value="vehicleMaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	@RequestMapping(value="vehicleMaintenances/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenances";
	}
}
