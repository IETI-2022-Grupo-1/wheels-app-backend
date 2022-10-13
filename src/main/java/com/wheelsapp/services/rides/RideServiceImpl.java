package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.exception.ExceptionGenerator;
import com.wheelsapp.exception.ExceptionType;
import com.wheelsapp.repositories.rides.RideRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Juan Cadavid
 */

@Service
public class RideServiceImpl implements RideService {
    private final RideRepository rideRepository;
    private final ModelMapper modelMapper;

    public RideServiceImpl(@Autowired RideRepository rideRepository, @Autowired ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.rideRepository = rideRepository;
    }

    @Override
    public RideDto createRide(RideDto rideDto) {
        Ride ride = new Ride(rideDto);
        RideDto rideDto1 = modelMapper.map(rideRepository.save(ride), RideDto.class);
        return rideDto1;
    }

    @Override
    public List<RideDto> getAllRides() {
        List<Ride> rides = rideRepository.findAll();
        List<RideDto> rideDTO = new ArrayList<>();
        for (Ride ride : rides) {
            rideDTO.add(modelMapper.map(ride, RideDto.class));
        }
        return rideDTO;
    }

    @Override
    public List<RideDto> getRideByUser(String userId) {
        List<RideDto> rides = new ArrayList<>();
        Date date = Date.from(Instant.now());
        for (RideDto ride: getAllRides()){
            if (ride.getJourneyDate().after(date) && ride.getIdDriver().equals(userId)) {
                rides.add(getRideDetail(ride.getId()));
            }
        }
        return rides;
    }

    @Override
    public RideDto getRideDetail(String id) {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(id);
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }
        return modelMapper.map(ride, RideDto.class);
    }

    @Override
    public RideDto updateRide(RideDto rideDto, String id) {
        Ride rideToUpdate = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(id);
        if (rideOpt.isPresent()) {
            rideToUpdate = rideOpt.get();
        }
        Ride ride2 = modelMapper.map(rideDto, Ride.class);
        rideToUpdate.updateRide(ride2);
        rideRepository.save(rideToUpdate);
        return modelMapper.map(rideToUpdate, RideDto.class);
    }

    @Override
    public RideDto deleteRide(String id) {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(id);
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
            ride.setIsActive(false);
            rideRepository.save(ride);
        }
        return modelMapper.map(ride, RideDto.class);
    }

    @Override
    public List<RideDto> getAllArrivalDate(String arrivalDate) {
        List<RideDto> rides = new ArrayList<>();
        Date date = convertStringDate(arrivalDate);
        for (RideDto ride : getAllRides()) {
            if (ride.getIsActive() && validateDate(convertDateCalendar(ride.getArrivalHour()), convertDateCalendar(date))) {
                rides.add(ride);
            }
        }
        return rides.stream().map(ride -> modelMapper.map(ride, RideDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RideDto> getAllDepartureDate(String departureDate) {
        List<RideDto> rides = new ArrayList<>();
        Date date = convertStringDate(departureDate);
        for (RideDto ride : getAllRides()) {
            if (ride.getIsActive() && validateDate(convertDateCalendar(ride.getDepartureHour()), convertDateCalendar(date))) {
                rides.add(ride);
            }
        }
        return rides.stream().map(ride -> modelMapper.map(ride, RideDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RideDto> getAllSeatsDate(Integer seatsAvailable) {
        List<RideDto> rides = new ArrayList<>();
        for (RideDto ride : getAllRides()) {
            if (Boolean.TRUE.equals(ride.getIsActive()) && (seatsAvailable <= ride.getAvailableSeats())) {

                rides.add(ride);
            }
        }
        return rides.stream().map(ride -> modelMapper.map(ride, RideDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RideDto> getKeyword(String keyword) {

        List<RideDto> rides = new ArrayList<>();
        for (RideDto ride : getAllRides()) {
            for (String keyw : ride.getRoute()) {
                if (Boolean.TRUE.equals(ride.getIsActive()) && keyword.equals(keyw)) {
                    rides.add(ride);
                }
            }
        }
        return rides.stream().map(ride -> modelMapper.map(ride, RideDto.class)).collect(Collectors.toList());
    }

    @Override
    public RideDto createReserve(RideDto rideDto) {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(rideDto.getId());
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }

        if (rideDto.getStopsList().size() > ride.getAvailableSeats()) {
            throw ExceptionGenerator.getException(ExceptionType.NOT_FOUND, "The required size is insufficient");
        }
        for (String i : rideDto.getStopsList().keySet()) {
            ride.getPassengerList().add(i.split("-")[0]);
        }
        ride.getStopsList().putAll(rideDto.getStopsList());
        ride.setAvailableSeats(ride.getAvailableSeats() - rideDto.getStopsList().size());
        ride.setSeatsReserved(ride.getSeatsReserved() + rideDto.getStopsList().size());
        rideRepository.save(ride);
        return modelMapper.map(ride, RideDto.class);
    }

    @Override
    public RideDto deleteReserve(String idRide, String idUser) {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(idRide);
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }
        ArrayList<String> passengersRemove = removePassenger(new ArrayList<>(ride.getPassengerList()), ride, idUser);
        HashMap<String, String> stopsRemove = removeStops(new HashMap<>(ride.getStopsList()), ride, idUser);
        int con = ride.getPassengerList().size() - passengersRemove.size();
        ride.setAvailableSeats(ride.getAvailableSeats() + con);
        ride.setSeatsReserved(ride.getSeatsReserved() - con);
        ride.setPassengerList(passengersRemove);
        ride.setStopsList(stopsRemove);
        rideRepository.save(ride);
        return modelMapper.map(ride, RideDto.class);
    }

    @Override
    public RideDto putReserve(RideDto rideDto) {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(rideDto.getId());
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }
        ArrayList<String> keys = new ArrayList<>(ride.getStopsList().keySet());
        ArrayList<String> passengers = removePassenger(new ArrayList<>(ride.getPassengerList()), ride, keys.get(0).split("-")[0]);
        HashMap<String, String> stops = removeStops(new HashMap<>(ride.getStopsList()), ride, keys.get(0).split("-")[0]);
        int availableSeats = ride.getAvailableSeats() + ride.getPassengerList().size() - passengers.size();
        int seatsReserved = ride.getSeatsReserved() - ride.getPassengerList().size() - passengers.size();
        if (rideDto.getStopsList().size() > availableSeats) {
            throw ExceptionGenerator.getException(ExceptionType.NOT_FOUND, "The required size is insufficient");
        }
        for (String i : rideDto.getStopsList().keySet()) {
            passengers.add(i.split("-")[0]);
        }
        stops.putAll(rideDto.getStopsList());
        ride.setPassengerList(passengers);
        ride.setStopsList(stops);
        ride.setAvailableSeats(availableSeats - stops.size());
        ride.setSeatsReserved(seatsReserved + stops.size());
        rideRepository.save(ride);
        return modelMapper.map(ride, RideDto.class);
    }

    public Date convertStringDate(String dateS) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(formatter.parse(dateS));
        } catch (ParseException e) {
            throw ExceptionGenerator.getException(ExceptionType.INVALID_OBJECT, "Date not found");
        }
        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - 5);
        return cal.getTime();
    }

    public Calendar convertDateCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    private Boolean validateDate(Calendar calRide, Calendar cal) {
        return calRide.get(Calendar.YEAR) == cal.get(Calendar.YEAR) && calRide.get(Calendar.MONTH) == cal.get(Calendar.MONTH) && calRide.get(Calendar.DATE) == cal.get(Calendar.DATE) && calRide.get(Calendar.HOUR) == cal.get(Calendar.HOUR);
    }

    private ArrayList<String> removePassenger(ArrayList<String> passengersRemove, Ride ride, String idUser) {
        for (String i : ride.getPassengerList()) {
            if ((i.equals(idUser)) && (!passengersRemove.remove(idUser))) {
                throw ExceptionGenerator.getException(ExceptionType.NOT_FOUND, "The passenger was impossible to delete");
            }
        }
        return passengersRemove;
    }

    private HashMap<String, String> removeStops(HashMap<String, String> stopsRemove, Ride ride, String idUser) {
        for (String key : ride.getStopsList().keySet()) {
            if ((key.split("-")[0].equals(idUser)) && (!stopsRemove.remove(key, ride.getStopsList().get(key)))) {
                throw ExceptionGenerator.getException(ExceptionType.NOT_FOUND, "The stops was impossible to delete");
            }
        }
        return stopsRemove;
    }
}
