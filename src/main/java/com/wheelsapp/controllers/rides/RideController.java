package com.wheelsapp.controllers.rides;

import com.wheelsapp.dto.rides.JourneyDto;
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

    @GetMapping("/arrival/{arrival_date}")
    public ResponseEntity<List<RideDto>> getAllArrivalDate(@PathVariable String arrival_date) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllArrivalDate(arrival_date);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/departure/{departure_date}")
    public ResponseEntity<List<RideDto>> getAllDepartureDate(@PathVariable String departure_date) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllDepartureDate(departure_date);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/seats-available/{seats_available}")
    public ResponseEntity<List<RideDto>> getAllSeatsDate(@PathVariable Integer seats_available) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getAllSeatsDate(seats_available);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("keyword/{keyword}")
    public ResponseEntity<List<RideDto>> getKeyword(@PathVariable String keyword) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Ride> rides = rideService.getKeyword(keyword);
            List<RideDto> ridesDto = new ArrayList<>();
            for (Ride ride : rides) {
                ridesDto.add(modelMapper.map(ride, RideDto.class));
            }
            return new ResponseEntity<>(ridesDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("journey/reserve")
    public ResponseEntity<RideDto> postReserveJourney(@RequestBody JourneyDto journeyDto){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Ride ride = rideService.postReserveJourney(journeyDto);
            RideDto rideDTO = modelMapper.map(ride, RideDto.class);
            return new ResponseEntity<>(rideDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("journey/{idRide}/{idUser}")
    public ResponseEntity<RideDto> deleteReserve(@PathVariable String idRide, @PathVariable String idUser) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Ride ride = rideService.deleteReserve(idRide, idUser);
            RideDto rideDTO = modelMapper.map(ride, RideDto.class);
            return new ResponseEntity<>(rideDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/journey/reserve")
    public ResponseEntity<RideDto> update(@RequestBody JourneyDto journeyDto){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Ride ride = rideService.putReserveJourney(journeyDto);
            RideDto rideDTO = modelMapper.map(ride, RideDto.class);
            return new ResponseEntity<>(rideDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}