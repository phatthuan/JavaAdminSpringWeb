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

import com.ntp.myadmin.models.InvoiceStatus;
import com.ntp.myadmin.services.InvoiceStatusService;



@Controller
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatuses")
    public String getinvoicestatus(Model model){
        List<InvoiceStatus> InvoiceStatusList = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoicestatuses", InvoiceStatusList);
        return "invoicestatus";
    }

    @RequestMapping("/invoiceStatuses/findById/{id}")
    @ResponseBody
    public Optional<InvoiceStatus> findById(@PathVariable Integer id){
        return invoiceStatusService.findById(id);
    }

    @PostMapping("/invoiceStatuses/addNew")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "invoiceStatuses/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }
}
