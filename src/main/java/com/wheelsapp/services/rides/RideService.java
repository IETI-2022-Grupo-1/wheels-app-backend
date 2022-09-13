package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.JourneyDto;
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
    List<Ride> getAllArrivalDate(String arrival_date) throws ParseException;
    List<Ride> getAllDepartureDate(String departure_date) throws ParseException;
    List<Ride> getAllSeatsDate(Integer seats_available);
    List<Ride> getKeyword(String keyword);
    Ride postReserveJourney(JourneyDto JourneyDto);
    Ride deleteReserve(String idRide, String idUser);
    Ride putReserveJourney(JourneyDto JourneyDto);
}
