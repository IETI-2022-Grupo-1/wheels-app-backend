package com.wheelsapp.service.impl;


import com.wheelsapp.entities.Vehicle;
import com.wheelsapp.repositories.VehicleRepository;
import com.wheelsapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VehicleServiceIMPL implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceIMPL(@Autowired VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicle.setCreatedAt(new Date());
        vehicle.setLastUpdate(new Date());
        return vehicleRepository.save(vehicle);
    }
    @Override
    public List<Vehicle> findAllByIdUser(String idUser) {
        List<Vehicle> x = vehicleRepository.findAll();
        List<Vehicle> y = new ArrayList<Vehicle>();
        for(Integer i = 0; i<x.size();i++){
            if(idUser.equals(x.get(i).getIdUser())){
                y.add(x.get(i));
            }
        }
        return y;
    }
    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }


    @Override
    public Vehicle getByVehicleId(String id){
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicle disableById(String id) {
        vehicleRepository.deleteById(id);

        return null;
    }
}
