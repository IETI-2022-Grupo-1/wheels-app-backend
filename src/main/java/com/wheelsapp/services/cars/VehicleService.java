package com.wheelsapp.services.cars;


import com.wheelsapp.dto.cars.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto create(VehicleDto vehicle);
    List<VehicleDto> getAllVehicle();

    List<VehicleDto> findAllByIdUser(String idUser);
    VehicleDto getByVehicleId(String id);
    VehicleDto disableById(String id);
    VehicleDto updateVehicle(VehicleDto vehicle, String id);
}
