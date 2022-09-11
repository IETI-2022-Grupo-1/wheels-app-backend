package com.wheelsapp.services.rides;

import com.wheelsapp.entities.rides.Ride;

import java.util.Date;
import java.util.List;

/**
 * @author Juan Cadavid
 */
public interface RideService {
    public List<Ride> getAll();
    public List<Ride> getAllArrivalDate(Date arrival_date);
    public List<Ride> getAllDepartureDate(Date departure_date);
    public List<Ride> getAllSeatsDate(Integer seats_available);
    public List<Ride> getKeyword(String keyword);
}
