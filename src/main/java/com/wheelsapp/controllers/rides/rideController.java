package com.wheelsapp.controllers.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.services.rides.RideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rides")
public class rideController {

    private final RideService rideService;


    public rideController(@Autowired RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping
    public ResponseEntity<List<RideDto>> getAll(){
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllRides();
            List<RideDto> rideDTO = new ArrayList<>();
            for (Ride ride : rides) {
                rideDTO.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<List<RideDto>>(rideDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{ride_id}")
    public ResponseEntity<RideDto> getRideDetails(@PathVariable String ride_id){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Ride ride = rideService.getRideDetail(ride_id);
            RideDto rideDto = modelMapper.map(ride, RideDto.class);
            return new ResponseEntity<RideDto>(rideDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<RideDto>> getRidesByUser(@PathVariable String user_id) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getRideByUser(user_id);
            List<RideDto> ridesDTO = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDTO.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<List<RideDto>>(ridesDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping
    public ResponseEntity<RideDto> create(@RequestBody RideDto rideDto){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Ride ride = rideService.createRide(new Ride(rideDto));
            RideDto rideDTO = modelMapper.map(ride, RideDto.class);
            return new ResponseEntity<RideDto>(rideDTO, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/{ride_id}")
    public ResponseEntity<RideDto> update(@RequestBody RideDto rideDto, @PathVariable String ride_id){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Ride ride = new Ride(rideDto);
            rideService.updateRide(ride, ride_id);
            RideDto rideDTO = modelMapper.map(ride, RideDto.class);
            return new ResponseEntity<RideDto>(rideDTO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{ride_id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String ride_id) {
        try {
            rideService.deleteRide(ride_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
