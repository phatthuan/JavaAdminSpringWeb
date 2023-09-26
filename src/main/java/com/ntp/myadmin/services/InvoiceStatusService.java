package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.InvoiceStatus;
import com.ntp.myadmin.repositories.InvoiceStatusRepository;



@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getInvoiceStatus(){
        return invoiceStatusRepository.findAll();
    }

    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> findById(Integer id){
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Integer id){
        invoiceStatusRepository.deleteById(id);
    }
}
