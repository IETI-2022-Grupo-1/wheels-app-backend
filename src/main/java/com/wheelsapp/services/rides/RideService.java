package com.wheelsapp.services.rides;

import com.wheelsapp.entities.rides.Ride;
import java.util.List;
import java.util.Optional;

public interface RideService {
    Ride createRide(Ride ride);
    List<Ride> getAllRides();
    List<Ride> getRideByUser(String userId);
    Ride getRideDetail(String id);
    Ride updateRide(Ride ride, String id);
    Ride deleteRide(String id);
}
