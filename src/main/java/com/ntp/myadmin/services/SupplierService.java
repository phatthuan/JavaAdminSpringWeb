package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.Supplier;
import com.ntp.myadmin.repositories.SupplierRepository;



@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> findById(Integer id){
        return supplierRepository.findById(id);
    }

    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }
}
