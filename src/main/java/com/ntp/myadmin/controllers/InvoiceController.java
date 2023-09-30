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

import com.ntp.myadmin.models.Invoice;
import com.ntp.myadmin.services.ClientService;
import com.ntp.myadmin.services.InvoiceService;
import com.ntp.myadmin.services.InvoiceStatusService;


@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoices")
    public String getInvoices(Model model){
        List<Invoice> InvoiceList = invoiceService.getInvoices();
        model.addAttribute("invoices", InvoiceList);
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatus());
        return "invoice";
    }

    @RequestMapping("/invoices/findById/{id}")
    @ResponseBody
    public Optional<Invoice> findById(@PathVariable Integer id){
        return invoiceService.findById(id);
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "invoices/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
