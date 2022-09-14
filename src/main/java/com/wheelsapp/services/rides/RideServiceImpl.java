package com.wheelsapp.services.rides;

import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.entities.users.User;
import com.wheelsapp.repositories.rides.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.Instant;

@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;

    public RideServiceImpl(@Autowired RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    @Override
    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }

    @Override
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    @Override
    public List<Ride> getRideByUser(String userId) {
        List<Ride> rides = new ArrayList<>();
        Date date = Date.from(Instant.now());
        for (Ride ride: getAllRides()){
            if (ride.getJourneyDate().after(date) && ride.getIdDriver().equals(userId)) {
                rides.add(getRideDetail(ride.getId()));
            }
        }
        return rides;
    }

    @Override
    public Ride getRideDetail(String id) {
        return rideRepository.findById(id).get();
    }

    @Override
    public Ride updateRide(Ride ride, String id) {
        Ride updateRide = rideRepository.findById(id).get();
        updateRide.setIdDriver(ride.getIdDriver());
        updateRide.setRoute(ride.getRoute());
        updateRide.setAvailableSeats(ride.getAvailableSeats());
        updateRide.setSeatsReserve(ride.getSeatsReserve());
        updateRide.setIsActive(ride.getIsActive());
        updateRide.setHasStarted(ride.getHasStarted());
        updateRide.setListPassenger(ride.getListPassenger());
        updateRide.setListStops(ride.getListStops());
        return rideRepository.save(updateRide);
    }

    @Override
    public Ride deleteRide(String id) {
        Ride ride = getRideDetail(id);
        ride.setIsActive(false);
        createRide(ride);
        return ride;
    }

}
