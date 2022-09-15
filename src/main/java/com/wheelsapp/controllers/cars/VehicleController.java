package com.wheelsapp.controllers.cars;


import com.wheelsapp.dto.cars.VehicleDto;
import com.wheelsapp.entities.cars.Vehicle;
import com.wheelsapp.services.cars.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/api/v1/vehicles" )
public class VehicleController {

    private final VehicleService vehicleService;
    public VehicleController(@Autowired VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Vehicle vehicle = modelMapper.map(vehicleDto,Vehicle.class);
            Vehicle vehicle2 = vehicleService.create(vehicle);
            VehicleDto vehicle1 = modelMapper.map(vehicle2, VehicleDto.class);
            return new ResponseEntity<>(vehicle1, HttpStatus.CREATED);
        }
         catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> consultByUser(@PathVariable String id ){
        try {
            List<Vehicle> vehicles = vehicleService.findAllByIdUser(id);
            List<VehicleDto> vehicleDtos = new ArrayList<VehicleDto>();
            for (Vehicle vehicle : vehicles) {
                ModelMapper modelMapper = new ModelMapper();
                VehicleDto vehicle1 = modelMapper.map(vehicle, VehicleDto.class);
                vehicleDtos.add(vehicle1);
            }
            return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public  ResponseEntity<?> consultAllVehicles(){
        try {
            List<Vehicle> vehicles = vehicleService.getAllVehicle();
            List<VehicleDto> vehicleDtos = new ArrayList<VehicleDto>();
            for (Vehicle vehicle : vehicles) {
                ModelMapper modelMapper = new ModelMapper();
                VehicleDto vehicle1 = modelMapper.map(vehicle, VehicleDto.class);
                vehicleDtos.add(vehicle1);
            }
            return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> consultByIdVehicle(@PathVariable String id){
        try {
            ModelMapper modelMapper = new ModelMapper();
            VehicleDto vehicle1 = modelMapper.map(vehicleService.getByVehicleId(id), VehicleDto.class);
            return new ResponseEntity<>(vehicle1, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyVehicle(@RequestBody VehicleDto vehicleDto,@PathVariable String id ){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Vehicle vehicle = modelMapper.map(vehicleDto,Vehicle.class);
            Vehicle vehicle2 = vehicleService.updateVehicle(vehicle, id);
            ModelMapper modelMapper2 = new ModelMapper();
            VehicleDto vehicle1 = modelMapper2.map(vehicle2, VehicleDto.class);
            return new ResponseEntity<>(vehicle1, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable String id){
        try{
            Vehicle vehicle = vehicleService.disableById(id);
            ModelMapper modelMapper = new ModelMapper();
            VehicleDto vehicle1 = modelMapper.map(vehicle, VehicleDto.class);
            return new ResponseEntity<>(vehicle1, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
