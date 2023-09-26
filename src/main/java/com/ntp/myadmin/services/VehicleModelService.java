package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.VehicleModel;
import com.ntp.myadmin.repositories.VehicleModelRepository;



@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }

    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModel> findById(Integer id){
        return vehicleModelRepository.findById(id);
    }

    public void delete(Integer id){
        vehicleModelRepository.deleteById(id);
    }
}
