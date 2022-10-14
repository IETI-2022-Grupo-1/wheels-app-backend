package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.entities.rides.Ride;

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

    List<RideDto> getAllArrivalDate(String arrivalDate);

    List<RideDto> getAllDepartureDate(String departureDate);

    List<RideDto> getAllSeatsDate(Integer seatsAvailable);

    List<RideDto> getKeyword(String keyword);

    RideDto createReserve(RideDto rideDto);

    RideDto deleteReserve(String idRide, String idUser);

    RideDto putReserve(RideDto rideDto);
}
