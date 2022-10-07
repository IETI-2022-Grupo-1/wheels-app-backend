package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.RideDto;
import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.repositories.rides.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

/**
 * @author Juan Cadavid
 */

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    public RideServiceImpl(@Autowired RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    @Override
    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }

    @Override
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    @Override
    public List<Ride> getRideByUser(String userId) {
        List<Ride> rides = new ArrayList<>();
        Date date = Date.from(Instant.now());
        for (Ride ride: getAllRides()){
            if (ride.getJourneyDate().after(date) && ride.getIdDriver().equals(userId)) {
                rides.add(getRideDetail(ride.getId()));
            }
        }
        return rides;
    }

    @Override
    public Ride getRideDetail(String id) {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(id);
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }
        return ride;
    }

    @Override
    public Ride updateRide(Ride ride, String id) {
        Ride rideToUpdate = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(id);
        if (rideOpt.isPresent()) {
            rideToUpdate = rideOpt.get();
        }
        rideToUpdate.updateRide(ride);
        return rideRepository.save(rideToUpdate);
    }

    @Override
    public Ride deleteRide(String id) {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(id);
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
            ride.setIsActive(false);
        }
        return ride;
    }

    @Override
    public List<Ride> getAllArrivalDate(String arrivalDate) throws ParseException {
        List<Ride> rides = new ArrayList<>();
        Date date = convertStringDate(arrivalDate);
        for(Ride ride: getAllRides()) {
            if (ride.getIsActive() && validateDate(convertDateCalendar(ride.getArrivalHour()), convertDateCalendar(date))) {
                    rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getAllDepartureDate(String departureDate) throws ParseException {
        List<Ride> rides = new ArrayList<>();
        Date date = convertStringDate(departureDate);
        for(Ride ride: getAllRides()) {
            if (ride.getIsActive() && validateDate(convertDateCalendar(ride.getDepartureHour()), convertDateCalendar(date))) {
                rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getAllSeatsDate(Integer seatsAvailable) {
        List<Ride> rides = new ArrayList<>();
        for(Ride ride: getAllRides()) {
            if (Boolean.TRUE.equals(ride.getIsActive()) && (seatsAvailable <= ride.getAvailableSeats())){

                rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getKeyword(String keyword) {

        List<Ride> rides = new ArrayList<>();
        for(Ride ride: getAllRides()) {
            for(String keyw: ride.getRoute()) {
                if (Boolean.TRUE.equals(ride.getIsActive()) && keyword.equals(keyw)) {
                    rides.add(ride);
                }
            }
        }
        return rides;
    }

    @Override
    public Ride createReserve(RideDto rideDto) throws Exception {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(rideDto.getId());
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }

        if(rideDto.getStopsList().size() > ride.getAvailableSeats()) {
            throw new Exception("The required size is insufficient");
        }
        for (String i: rideDto.getStopsList().keySet()) {
            ride.getPassengerList().add(i.split("-")[0]);
        }
        ride.getStopsList().putAll(rideDto.getStopsList());
        ride.setAvailableSeats(ride.getAvailableSeats()-rideDto.getStopsList().size());
        ride.setSeatsReserved(ride.getSeatsReserved()+rideDto.getStopsList().size());
        rideRepository.save(ride);
        return ride;
    }

    @Override
    public Ride deleteReserve(String idRide, String idUser) throws Exception {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(idRide);
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }
        ArrayList<String> passengersRemove = removePassenger(new ArrayList<>(ride.getPassengerList()), ride, idUser);
        HashMap<String, String> stopsRemove = removeStops(new HashMap<>(ride.getStopsList()), ride, idUser);
        int con = ride.getPassengerList().size()-passengersRemove.size();
        ride.setAvailableSeats(ride.getAvailableSeats() + con);
        ride.setSeatsReserved(ride.getSeatsReserved() - con);
        ride.setPassengerList(passengersRemove);
        ride.setStopsList(stopsRemove);
        rideRepository.save(ride);
        return ride;
    }

    @Override
    public Ride putReserve(RideDto rideDto) throws Exception {
        Ride ride = new Ride();
        Optional<Ride> rideOpt = rideRepository.findById(rideDto.getId());
        if (rideOpt.isPresent()) {
            ride = rideOpt.get();
        }
        ArrayList<String> keys = new ArrayList<>(ride.getStopsList().keySet());
        ArrayList<String> passengers = removePassenger(new ArrayList<>(ride.getPassengerList()), ride, keys.get(0).split("-")[0]);
        HashMap<String, String> stops = removeStops(new HashMap<>(ride.getStopsList()), ride, keys.get(0).split("-")[0]);
        int availableSeats = ride.getAvailableSeats() + ride.getPassengerList().size()-passengers.size();
        int seatsReserved = ride.getSeatsReserved() - ride.getPassengerList().size()-passengers.size();
        if(rideDto.getStopsList().size() > availableSeats) {
            throw new Exception("The required size is insufficient");
        }
        for (String i: rideDto.getStopsList().keySet()) {
            passengers.add(i.split("-")[0]);
        }
        stops.putAll(rideDto.getStopsList());
        ride.setPassengerList(passengers);
        ride.setStopsList(stops);
        ride.setAvailableSeats(availableSeats-stops.size());
        ride.setSeatsReserved(seatsReserved+stops.size());
        rideRepository.save(ride);
        return ride;
    }

    public Date convertStringDate(String dateS) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter.parse(dateS));
        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR)-5);
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

    private ArrayList<String> removePassenger (ArrayList<String> passengersRemove, Ride ride,String idUser) throws Exception {
        for (String i: ride.getPassengerList()) {
            if ((i.equals(idUser)) && (!passengersRemove.remove(idUser))) {
                throw new Exception("The user was impossible to delete");
            }
        }
        return passengersRemove;
    }

    private HashMap<String, String> removeStops (HashMap<String, String> stopsRemove, Ride ride,String idUser) throws Exception {
        for (String key: ride.getStopsList().keySet()) {
            if ((key.split("-")[0].equals(idUser)) && (!stopsRemove.remove(key, ride.getStopsList().get(key)))) {
                throw new Exception("The user was impossible to delete");
            }
        }
        return stopsRemove;
    }
}
