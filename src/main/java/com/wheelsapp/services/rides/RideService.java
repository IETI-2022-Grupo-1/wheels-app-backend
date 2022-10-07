package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.entities.rides.Ride;

import java.text.ParseException;
import java.util.List;

/**
 * @author Juan Cadavid
 */
public interface RideService {
    Ride createRide(Ride ride);
    List<Ride> getAllRides();
    List<Ride> getRideByUser(String userId);
    Ride getRideDetail(String id);
    Ride updateRide(Ride ride, String id);
    Ride deleteRide(String id);
    List<Ride> getAllArrivalDate(String arrivalDate) throws ParseException;
    List<Ride> getAllDepartureDate(String departureDate) throws ParseException;
    List<Ride> getAllSeatsDate(Integer seatsAvailable);
    List<Ride> getKeyword(String keyword);
    Ride createReserve(RideDto rideDto) throws Exception;
    Ride deleteReserve(String idRide, String idUser) throws Exception;
    Ride putReserve(RideDto rideDto) throws Exception;
}
