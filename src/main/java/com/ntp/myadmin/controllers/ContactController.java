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

import com.ntp.myadmin.models.Contact;
import com.ntp.myadmin.services.ContactService;



@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getcontacts(Model model){
        List<Contact> contactList = contactService.getContacts();
        model.addAttribute("contacts", contactList);
        return "contact";
    }

    @RequestMapping("/contacts/findById/{id}")
    @ResponseBody
    public Optional<Contact> findById(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @PostMapping("/contacts/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "contacts/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
