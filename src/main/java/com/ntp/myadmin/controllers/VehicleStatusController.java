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

import com.ntp.myadmin.models.VehicleStatus;
import com.ntp.myadmin.services.VehicleStatusService;



@Controller
public class VehicleStatusController {
    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatuses")
    public String getvehiclestatus(Model model){
        List<VehicleStatus> VehicleStatusList = vehicleStatusService.getVehicleStatus();
        model.addAttribute("vehiclestatuses", VehicleStatusList);
        return "vehiclestatus";
    }

    @RequestMapping("/vehicleStatuses/findById/{id}")
    @ResponseBody
    public Optional<VehicleStatus> findById(@PathVariable Integer id){
        return vehicleStatusService.findById(id);
    }

    @PostMapping("/vehicleStatuses/addNew")
    public String addNew(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "vehicleStatuses/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }
}
