package com.wheelsapp.services.rides;

import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.repositories.rides.rideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.wheelsapp.repositories.rides.rideRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class rideServiceImpl implements rideService{

    private final  rideRepository rideRepository;

    public rideServiceImpl(@Autowired rideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    @Override
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    @Override
    public List<Ride> getRideByUser(String userId) {
        return null;
    }

    @Override
    public Ride getRideDetail(String id) {
        return rideRepository.findById(id).get();
    }
}
