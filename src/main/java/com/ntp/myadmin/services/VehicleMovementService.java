package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.VehicleMovement;
import com.ntp.myadmin.repositories.VehicleMovementRepository;



@Service
public class VehicleMovementService {
    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    public List<VehicleMovement> getVehicleMovements(){
        return vehicleMovementRepository.findAll();
    }

    public void save(VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    public Optional<VehicleMovement> findById(Integer id){
        return vehicleMovementRepository.findById(id);
    }

    public void delete(Integer id){
        vehicleMovementRepository.deleteById(id);
    }
}
