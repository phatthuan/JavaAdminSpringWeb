package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.EmployeeType;
import com.ntp.myadmin.repositories.EmployeeTypeRepository;



@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> findById(Integer id){
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id){
        employeeTypeRepository.deleteById(id);
    }
}
