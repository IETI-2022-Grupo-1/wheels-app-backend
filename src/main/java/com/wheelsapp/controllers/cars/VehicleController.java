package com.wheelsapp.controllers.cars;


import com.wheelsapp.dto.cars.VehicleDto;
import com.wheelsapp.services.cars.VehicleService;
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
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto){

        try {
            return new ResponseEntity<>(vehicleService.create(vehicleDto), HttpStatus.CREATED);
        }
         catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<VehicleDto>> consultByUser(@PathVariable String id ){
        try {
            return new ResponseEntity<>(vehicleService.findAllByIdUser(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public  ResponseEntity<List<VehicleDto>> consultAllVehicles(){
        try {
            return new ResponseEntity<>(vehicleService.getAllVehicle(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> consultByIdVehicle(@PathVariable String id){
        try {
            return new ResponseEntity<>(vehicleService.getByVehicleId(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> modifyVehicle(@RequestBody VehicleDto vehicleDto,@PathVariable String id ){
        try {
            return new ResponseEntity<>(vehicleService.updateVehicle(vehicleDto, id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<VehicleDto> deleteVehicle(@PathVariable String id){
        try{
            return new ResponseEntity<>(vehicleService.disableById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
