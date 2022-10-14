package com.wheelsapp.controllers.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.services.rides.RideService;
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
        return new ResponseEntity<>(rideService.getAllRides(), HttpStatus.OK);
    }

    @GetMapping("/{rideId}")
    public ResponseEntity<RideDto> getRideDetails(@PathVariable String rideId) {
        return new ResponseEntity<>(rideService.getRideDetail(rideId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RideDto>> getRidesByUser(@PathVariable String userId) {
        return new ResponseEntity<>(rideService.getRideByUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{rideId}")
    public ResponseEntity<RideDto> deleteById(@PathVariable String rideId) {
        return new ResponseEntity<>(rideService.deleteRide(rideId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RideDto> create(@RequestBody RideDto rideDto) {
        return new ResponseEntity<>(rideService.createRide(rideDto), HttpStatus.CREATED);
    }

    @PutMapping("/{rideId}")
    public ResponseEntity<RideDto> update(@RequestBody RideDto rideDto, @PathVariable String rideId) {
        return new ResponseEntity<>(rideService.updateRide(rideDto, rideId), HttpStatus.OK);
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