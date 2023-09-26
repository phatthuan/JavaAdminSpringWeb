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

import com.ntp.myadmin.models.VehicleModel;
import com.ntp.myadmin.services.VehicleModelService;



@Controller
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicleModels")
    public String getvehiclemodels(Model model){
        List<VehicleModel> VehicleModelList = vehicleModelService.getVehicleModels();
        model.addAttribute("vehiclemodels", VehicleModelList);
        return "vehiclemodel";
    }

    @RequestMapping("/vehicleModels/findById/{id}")
    @ResponseBody
    public Optional<VehicleModel> findById(@PathVariable Integer id){
        return vehicleModelService.findById(id);
    }

    @PostMapping("/vehicleModels/addNew")
    public String addNew(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "vehicleModels/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        vehicleModelService.delete(id);
        return "redirect:/vehicleModels";
    }
}
