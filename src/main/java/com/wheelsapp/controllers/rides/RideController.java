package com.wheelsapp.controllers.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.services.rides.RideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Juan Cadavid
 */

@RestController
@RequestMapping("/api/v1/rides")
public class RideController {
    private final RideService rideService;

    public RideController(@Autowired RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping
    public ResponseEntity<List<RideDto>> getAll() {
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAll();
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/arrival/{arrival_date}")
    public ResponseEntity<List<RideDto>> getAllArrivalDate(@PathVariable Date arrival_date) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllArrivalDate(arrival_date);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/departure/{departure_date}")
    public ResponseEntity<List<RideDto>> getAllDepartureDate(@PathVariable Date departure_date) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllDepartureDate(departure_date);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/seats-available/{seats_available}")
    public ResponseEntity<List<RideDto>> getAllSeatsDate(@PathVariable Integer seats_available) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllSeatsDate(seats_available);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("keyword/{keyword}")
    public ResponseEntity<List<RideDto>> getKeyword(@PathVariable String keyword) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getKeyword(keyword);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
