package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.VehicleType;
import com.ntp.myadmin.repositories.VehicleTypeRepository;



@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getVehicleTypes(){
        return vehicleTypeRepository.findAll();
    }

    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    public Optional<VehicleType> findById(Integer id){
        return vehicleTypeRepository.findById(id);
    }

    public void delete(Integer id){
        vehicleTypeRepository.deleteById(id);
    }
}
