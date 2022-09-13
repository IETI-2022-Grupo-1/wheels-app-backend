package com.wheelsapp.service;


import com.wheelsapp.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle create(Vehicle vehicle);
    List<Vehicle> getAllVehicle();

    List<Vehicle> findAllByIdUser(String idUser);
    Vehicle getByVehicleId(String id);
    Vehicle disableById(String id);
    Vehicle updateVehicle(Vehicle vehicle);
}
