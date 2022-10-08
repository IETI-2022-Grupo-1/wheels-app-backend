package com.wheelsapp.controllers.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.services.rides.RideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllRides();
            List<RideDto> rideDTO = new ArrayList<>();
            for (Ride ride : rides) {
                rideDTO.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(rideDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{rideId}")
    public ResponseEntity<RideDto> getRideDetails(@PathVariable String rideId) {
        ModelMapper modelMapper = new ModelMapper();
        Ride ride = rideService.getRideDetail(rideId);
        RideDto rideDto = modelMapper.map(ride, RideDto.class);
        return new ResponseEntity<>(rideDto, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RideDto>> getRidesByUser(@PathVariable String userId) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getRideByUser(userId);
            List<RideDto> ridesDTO = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDTO.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{rideId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String rideId) {
        try {
            rideService.deleteRide(rideId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<RideDto> create(@RequestBody RideDto rideDto) {
        ModelMapper modelMapper = new ModelMapper();
        Ride ride = rideService.createRide(new Ride(rideDto));
        RideDto rideDTO = modelMapper.map(ride, RideDto.class);
        return new ResponseEntity<>(rideDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{rideId}")
    public ResponseEntity<RideDto> update(@RequestBody RideDto rideDto, @PathVariable String rideId) {
        ModelMapper modelMapper = new ModelMapper();
        Ride ride = new Ride(rideDto);
        rideService.updateRide(ride, rideId);
        RideDto rideDTO = modelMapper.map(ride, RideDto.class);
        return new ResponseEntity<>(rideDTO, HttpStatus.OK);
    }

    @GetMapping("/arrival/{arrivalDate}")
    public ResponseEntity<List<RideDto>> getAllArrivalDate(@PathVariable String arrivalDate) {
        return new ResponseEntity<>(rideService.getAllArrivalDate(arrivalDate), HttpStatus.OK);
    }

    @GetMapping("/departure/{departureDate}")
    public ResponseEntity<List<RideDto>> getAllDepartureDate(@PathVariable String departureDate) {
        return new ResponseEntity<>(rideService.getAllDepartureDate(departureDate), HttpStatus.OK);
    }

    @GetMapping("/seats-available/{seatsAvailable}")
    public ResponseEntity<List<RideDto>> getAllSeatsDate(@PathVariable Integer seatsAvailable) {
        return new ResponseEntity<>(rideService.getAllSeatsDate(seatsAvailable), HttpStatus.OK);

    }

    @GetMapping("keyword/{keyword}")
    public ResponseEntity<List<RideDto>> getKeyword(@PathVariable String keyword) {
        return new ResponseEntity<>(rideService.getKeyword(keyword), HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<RideDto> postReserve(@RequestBody RideDto rideDto) {
        return new ResponseEntity<>(rideService.createReserve(rideDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/reserve/{idRide}/{idUser}")
    public ResponseEntity<RideDto> deleteReserve(@PathVariable String idRide, @PathVariable String idUser) {
        return new ResponseEntity<>(rideService.deleteReserve(idRide, idUser), HttpStatus.OK);
    }

    @PutMapping("/reserve")
    public ResponseEntity<RideDto> updateReserve(@RequestBody RideDto rideDto) {
        return new ResponseEntity<>(rideService.putReserve(rideService.putReserve(rideDto)), HttpStatus.CREATED);
    }
}