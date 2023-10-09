package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.Vehicle;
import com.ntp.myadmin.repositories.VehicleRepository;



@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> findById(Integer id){
        return vehicleRepository.findById(id);
    }

    public void delete(Integer id){
        vehicleRepository.deleteById(id);
    }
}
