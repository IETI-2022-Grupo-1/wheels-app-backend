package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.RideDto;

import java.util.List;

/**
 * @author Juan Cadavid
 */
public interface RideService {
    RideDto createRide(RideDto rideDto);

    List<RideDto> getAllRides();

    List<RideDto> getRideByUser(String userId);

    RideDto getRideDetail(String id);

    RideDto updateRide(RideDto rideDto, String id);

    RideDto deleteRide(String id);

    List<RideDto> getAllArrivalDate(String arrivalDate);

    List<RideDto> getAllDepartureDate(String departureDate);

    List<RideDto> getAllSeatsDate(Integer seatsAvailable);

    List<RideDto> getKeyword(String keyword);

    RideDto createReserve(RideDto rideDto);

    RideDto deleteReserve(String idRide, String idUser);

    RideDto putReserve(RideDto rideDto);
}
