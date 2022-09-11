package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.repositories.rides.RideRepository;
import com.wheelsapp.services.rides.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Juan Cadavid
 */

@Service
public class RideImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    public List<RideDto> getAll() {
        return null;
    }

    @Override
    public List<RideDto> getAllDepartureDate(Date departure_date) {
        return null;
    }

    @Override
    public List<RideDto> getAllSeatsDate(Integer seats_available) {
        return null;
    }

    @Override
    public List<RideDto> getKeyword(String keyword) {
        return null;
    }
}
