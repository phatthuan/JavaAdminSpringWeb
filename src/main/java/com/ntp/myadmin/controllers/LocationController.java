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

import com.ntp.myadmin.models.Location;
import com.ntp.myadmin.services.CountryService;
import com.ntp.myadmin.services.LocationService;
import com.ntp.myadmin.services.StateService;



@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/locations")
    public String getlocations(Model model){
        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        return "location";
    }

    @RequestMapping("/locations/findById/{id}")
    @ResponseBody
    public Optional<Location> findById(@PathVariable Integer id){
        return locationService.findById(id);
    }

    @PostMapping("/locations/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "locations/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }
    
}
