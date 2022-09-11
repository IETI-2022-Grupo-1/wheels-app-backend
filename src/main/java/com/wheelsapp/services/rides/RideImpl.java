package com.wheelsapp.services.rides;

import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.repositories.rides.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Juan Cadavid
 */

@Service
public class RideImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Override
    public List<Ride> getAll() {
        List<Ride> rides = new ArrayList<>();
        rides.addAll(rideRepository.findAll());
        return rides;
    }

    @Override
    public List<Ride> getAllArrivalDate(Date arrival_date) {
        List<Ride> rides = new ArrayList<>();
        Date date = Date.from(Instant.now());
        for(Ride ride: getAll()) {
            if(ride.getHourArrival().getDate() > date.getDate() && ride.getHourArrival().getHours() > date.getHours()) {
                rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getAllDepartureDate(Date departure_date) {
        List<Ride> rides = new ArrayList<>();
        Date date = Date.from(Instant.now());
        for(Ride ride: getAll()) {
            if(ride.getHouDeparture().getDate() > date.getDate() && ride.getHouDeparture().getHours() > date.getHours()) {
                rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getAllSeatsDate(Integer seats_available) {
        List<Ride> rides = new ArrayList<>();
        for(Ride ride: getAll()) {
            if(seats_available == ride.getAvailableSeats()) {
                rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getKeyword(String keyword) {
        List<Ride> rides = new ArrayList<>();
        for(Ride ride: getAll()) {
            for(String keyw: ride.getRoute()) {
                if(keyword == keyw) {
                    rides.add(ride);
                }
            }

        }
        return rides;
    }
}
