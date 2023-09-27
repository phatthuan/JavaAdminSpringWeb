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

import com.ntp.myadmin.models.Client;
import com.ntp.myadmin.services.ClientService;
import com.ntp.myadmin.services.CountryService;
import com.ntp.myadmin.services.StateService;

@Controller
public class ClientController {
    @Autowired private StateService stateService;
	@Autowired private CountryService countryService;	
	@Autowired private ClientService clientService;
	
	//Get All Clients
	@GetMapping("/clients")
	public String findAll(Model model){		
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("clients", clientService.getClients());
		return "client";
	}	
	
	@RequestMapping("clients/findById/{id}") 
	@ResponseBody
	public Optional<Client> findById(@PathVariable Integer id)
	{
		return clientService.findById(id);
	}
	
	//Add Client
	@PostMapping(value="clients/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}	
	
	@RequestMapping(value="clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable Integer id) {
		clientService.delete(id);
		return "redirect:/clients";
	}
}
