package com.wheelsapp.services.rides;

import com.wheelsapp.entities.rides.Ride;
import java.util.List;

public interface rideService {
    List<Ride> getAllRides();
    List<Ride> getRideByUser(String userId);
    Ride getRideDetail(String id);
}
