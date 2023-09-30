package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.Invoice;
import com.ntp.myadmin.repositories.InvoiceRepository;



@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> findById(Integer id){
        return invoiceRepository.findById(id);
    }

    public void delete(Integer id){
        invoiceRepository.deleteById(id);
    }
}
