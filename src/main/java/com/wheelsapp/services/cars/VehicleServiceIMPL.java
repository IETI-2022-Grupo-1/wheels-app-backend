package com.wheelsapp.services.cars;


import com.wheelsapp.dto.cars.VehicleDto;
import com.wheelsapp.entities.cars.Vehicle;
import com.wheelsapp.exception.ExceptionGenerator;
import com.wheelsapp.exception.ExceptionType;
import com.wheelsapp.repositories.cars.VehicleRepository;
import com.wheelsapp.services.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleServiceIMPL implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    public VehicleServiceIMPL(@Autowired VehicleRepository vehicleRepository, @Autowired UserService userService, @Autowired ModelMapper modelMapper){
        this.vehicleRepository = vehicleRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @Override
    public VehicleDto create(VehicleDto vehicleDto) {
        Vehicle vehicle = modelMapper.map(vehicleDto,Vehicle.class);
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
            VehicleDto vehicle1 = modelMapper.map(vehicle, VehicleDto.class);
            vehicleDtos.add(vehicle1);
        }
        return vehicleDtos;
    }
    @Override
    public VehicleDto getByVehicleId(String id){
        Optional<Vehicle> isVehiclePresent = vehicleRepository.findById(id);
        if(isVehiclePresent.isPresent()) {
            return modelMapper.map(vehicleRepository.findById(id).orElse(null), VehicleDto.class);
        }
        throw ExceptionGenerator.getException(ExceptionType.NOT_FOUND,"Error, the vehicle not found");
    }

    @Override
    public VehicleDto disableById(String id) {
        VehicleDto vehicleDto= getByVehicleId(id);
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        vehicle.setIsActive(false);
        vehicle.setLastUpdate(new Date());
        vehicleRepository.save(vehicle);
        return modelMapper.map(vehicle, VehicleDto.class);
    }
    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto, String id){
        Vehicle vehicle = modelMapper.map(vehicleDto,Vehicle.class);
        Vehicle vehicleToUpdate = modelMapper.map(getByVehicleId(id),Vehicle.class);
        vehicleToUpdate.update(vehicle);
        vehicleRepository.save(vehicleToUpdate);
        return modelMapper.map(vehicleToUpdate, VehicleDto.class);
    }
}
