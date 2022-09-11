package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.RideDto;

import java.util.Date;
import java.util.List;

/**
 * @author Juan Cadavid
 */
public interface RideService {
    public List<RideDto> getAll();
    public List<RideDto> getAllDepartureDate(Date departure_date);
    public List<RideDto> getAllSeatsDate(Integer seats_available);
    public List<RideDto> getKeyword(String keyword);
}
