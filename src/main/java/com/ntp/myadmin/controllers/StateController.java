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

import com.ntp.myadmin.models.State;
import com.ntp.myadmin.services.CountryService;
import com.ntp.myadmin.services.StateService;



@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String getstates(Model model){
        List<State> StateList = stateService.getStates();
        model.addAttribute("states", StateList);
        model.addAttribute("countries", countryService.getCountries());
        return "state";
    }

    @RequestMapping("/states/findById/{id}")
    @ResponseBody
    public Optional<State> findById(@PathVariable Integer id){
        return stateService.findById(id);
    }

    @PostMapping("/states/addNew")
    public String addNew(State State){
        stateService.save(State);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State State){
        stateService.save(State);
        return "redirect:/states";
    }

    @RequestMapping(value = "states/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        stateService.delete(id);
        return "redirect:/states";
    }
}
