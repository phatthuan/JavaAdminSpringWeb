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

import com.ntp.myadmin.models.VehicleMake;
import com.ntp.myadmin.services.VehicleMakeService;



@Controller
public class VehicleMakeController {
    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMakes")
    public String getVehicleMakes(Model model){
        List<VehicleMake> VehicleMakeList = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehiclemakes", VehicleMakeList);
        return "vehiclemake";
    }

    @RequestMapping("/vehicleMakes/findById/{id}")
    @ResponseBody
    public Optional<VehicleMake> findById(@PathVariable Integer id){
        return vehicleMakeService.findById(id);
    }

    @PostMapping("/vehicleMakes/addNew")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "vehicleMakes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMakes";
    }
}
