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
        ModelMapper modelMapper = new ModelMapper();
        List<Ride> rides = rideService.getAllRides();
        List<RideDto> rideDTO = new ArrayList<>();
        for (int i = 0; i<rides.size(); i++){
            rideDTO.add(modelMapper.map(i, RideDto.class));
        }
        return new ResponseEntity<List<RideDto>>(rideDTO, HttpStatus.OK);
    }

    @GetMapping("/{ride_id}")
    public ResponseEntity<RideDto> getRideDetails(@PathVariable String ride_id){
        ModelMapper modelMapper = new ModelMapper();
        Ride ride = rideService.getRideDetail(ride_id);
        RideDto rideDto = modelMapper.map(ride, RideDto.class);
        return new ResponseEntity<RideDto>(rideDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RideDto> create(@RequestBody RideDto rideDto){
        ModelMapper modelMapper = new ModelMapper();
        Ride ride = rideService.createRide(new Ride(rideDto));
        RideDto rideDTO = modelMapper.map(ride, RideDto.class);
        return new ResponseEntity<RideDto>(rideDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{ride_id}")
    public ResponseEntity<RideDto> update(@RequestBody RideDto rideDto, @PathVariable String ride_id){
        ModelMapper modelMapper = new ModelMapper();
        Ride ride = new Ride(rideDto);
        rideService.updateRide(ride, ride_id);
        RideDto rideDTO = modelMapper.map(ride, RideDto.class);
        return new ResponseEntity<RideDto>(rideDTO, HttpStatus.OK);
    }

}
