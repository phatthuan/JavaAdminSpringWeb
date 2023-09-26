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

import com.ntp.myadmin.models.VehicleType;
import com.ntp.myadmin.services.VehicleTypeService;



@Controller
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleTypes")
    public String getVehicleTypes(Model model){
        List<VehicleType> VehicleTypeList = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicletypes", VehicleTypeList);
        return "vehicletype";
    }

    @RequestMapping("/vehicleTypes/findById/{id}")
    @ResponseBody
    public Optional<VehicleType> findById(@PathVariable Integer id){
        return vehicleTypeService.findById(id);
    }

    @PostMapping("/vehicleTypes/addNew")
    public String addNew(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "vehicleTypes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }
}
