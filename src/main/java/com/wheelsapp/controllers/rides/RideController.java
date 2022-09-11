package com.wheelsapp.controllers.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.services.rides.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return null;
    }

    @GetMapping("/arrival/{arrival_date}")
    public ResponseEntity<List<RideDto>> getAllArrivalDate(@PathVariable Date arrival_date) {
        return null;
    }

    @GetMapping("/departure/{departure_date}")
    public ResponseEntity<List<RideDto>> getAllDepartureDate(@PathVariable Date departure_date) {
        return null;
    }

    @GetMapping("/seats-available/{seats_available}")
    public ResponseEntity<List<RideDto>> getAllSeatsDate(@PathVariable Integer seats_available) {
         return null;
    }

    @GetMapping("keyword/{keyword}")
    public ResponseEntity<List<RideDto>> getKeyword(@PathVariable String keyword) {
        return null;
    }
}
