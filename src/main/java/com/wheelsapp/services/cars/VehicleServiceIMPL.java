package com.wheelsapp.services.cars;


import com.wheelsapp.dto.cars.VehicleDto;
import com.wheelsapp.entities.cars.Vehicle;
import com.wheelsapp.repositories.cars.VehicleRepository;
import com.wheelsapp.services.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class VehicleServiceIMPL implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserService userService;
    public VehicleServiceIMPL(@Autowired VehicleRepository vehicleRepository, @Autowired UserService userService){
        this.vehicleRepository = vehicleRepository;
        this.userService = userService;
    }
    @Override
    public VehicleDto create(VehicleDto vehicleDto) {
        ModelMapper modelMapper = new ModelMapper();
        Vehicle vehicle = modelMapper.map(vehicleDto,Vehicle.class);
        vehicle.setCreatedAt(new Date());
        vehicle.setLastUpdate(new Date());
        userService.createDriver(vehicle.getIdUser());
        vehicleRepository.save(vehicle);
        return modelMapper.map(vehicle, VehicleDto.class);
    }
    @Override
    public List<VehicleDto> findAllByIdUser(String idUser) {
        List<Vehicle> x = vehicleRepository.findAll();
        List<VehicleDto> y = new ArrayList<>();
        for(Integer i = 0; i<x.size();i++){
            if(idUser.equals(x.get(i).getIdUser())){
                ModelMapper modelMapper = new ModelMapper();
                VehicleDto vehicle1 = modelMapper.map(x.get(i), VehicleDto.class);
                y.add(vehicle1);
            }
        }

        return y;
    }
    @Override
    public List<VehicleDto> getAllVehicle() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            ModelMapper modelMapper = new ModelMapper();
            VehicleDto vehicle1 = modelMapper.map(vehicle, VehicleDto.class);
            vehicleDtos.add(vehicle1);
        }
        return vehicleDtos;
    }


    @Override
    public VehicleDto getByVehicleId(String id){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehicleRepository.findById(id).orElse(null), VehicleDto.class);
    }


    @Override
    public VehicleDto disableById(String id) {
        Vehicle vehicle =vehicleRepository.findById(id).orElse(null);
        vehicle.setIsActive(false);
        vehicle.setLastUpdate(new Date());
        vehicleRepository.save(vehicle);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehicle, VehicleDto.class);
    }
    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto, String id){
        ModelMapper modelMapper = new ModelMapper();
        Vehicle vehicle = modelMapper.map(vehicleDto,Vehicle.class);
        Vehicle vehicle1 = vehicleRepository.findById(id).orElse(null);
        vehicle1.update(vehicle);
        vehicleRepository.save(vehicle1);
        return modelMapper.map(vehicle1, VehicleDto.class);
    }
}
