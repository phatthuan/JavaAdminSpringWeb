package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.VehicleStatus;
import com.ntp.myadmin.repositories.VehicleStatusRepository;



@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehicleStatus(){
        return vehicleStatusRepository.findAll();
    }

    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> findById(Integer id){
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id){
        vehicleStatusRepository.deleteById(id);
    }
}
