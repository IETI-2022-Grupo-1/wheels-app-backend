package com.wheelsapp.service;


import com.wheelsapp.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle create(Vehicle vehicle);
    List<Vehicle> getAllVehicle();
    Vehicle findById(String id);
    Vehicle disableById(String id);
}
