package com.wheelsapp.controllers;


import com.wheelsapp.dto.VehicleDto;
import com.wheelsapp.entities.Vehicle;
import com.wheelsapp.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/vehicles" )
public class VehicleController {

    private final VehicleService vehicleService;
    public VehicleController(@Autowired VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle){
        Vehicle vehicle2 = vehicleService.create(vehicle);
        ModelMapper modelMapper = new ModelMapper();
        VehicleDto vehicle1 = modelMapper.map(vehicle2, VehicleDto.class);
        return new ResponseEntity<>(vehicle1, HttpStatus.CREATED);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> consultByUser(@PathVariable String id ){
        return new ResponseEntity<>(vehicleService.findAllByIdUser(id), HttpStatus.CREATED);
    }
    @GetMapping
    public  ResponseEntity<?> consultAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicle(), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> consultByIdVehicle(@PathVariable String id){
        return new ResponseEntity<>(vehicleService.getByVehicleId(id),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> modifyVehicle(@RequestBody Vehicle vehicle){
        Vehicle vehicle2 = vehicleService.create(vehicle);
        ModelMapper modelMapper = new ModelMapper();
        VehicleDto vehicle1 = modelMapper.map(vehicle2, VehicleDto.class);
        return new ResponseEntity<>(vehicle1, HttpStatus.CREATED);
    }




}
