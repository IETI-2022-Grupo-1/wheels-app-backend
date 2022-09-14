package com.wheelsapp.services.cars;


import com.wheelsapp.entities.cars.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle create(Vehicle vehicle);
    List<Vehicle> getAllVehicle();

    List<Vehicle> findAllByIdUser(String idUser);
    Vehicle getByVehicleId(String id);
    Vehicle disableById(String id);
    Vehicle updateVehicle(Vehicle vehicle, String id);
}
