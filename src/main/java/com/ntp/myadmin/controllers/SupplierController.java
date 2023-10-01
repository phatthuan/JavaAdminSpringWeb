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

import com.ntp.myadmin.models.Supplier;
import com.ntp.myadmin.services.CountryService;
import com.ntp.myadmin.services.StateService;
import com.ntp.myadmin.services.SupplierService;



@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired 
    private StateService stateService;

    @GetMapping("/suppliers")
    public String getSuppliers(Model model){
        List<Supplier> SupplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers", SupplierList);
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        return "supplier";
    }

    @RequestMapping("/suppliers/findById/{id}")
    @ResponseBody
    public Optional<Supplier> findById(@PathVariable Integer id){
        return supplierService.findById(id);
    }

    @PostMapping("/suppliers/addNew")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "suppliers/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
