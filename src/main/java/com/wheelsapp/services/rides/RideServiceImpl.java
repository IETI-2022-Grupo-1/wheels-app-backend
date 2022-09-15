package com.wheelsapp.services.rides;

import com.wheelsapp.dto.rides.JourneyDto;
import com.wheelsapp.entities.rides.Ride;
import com.wheelsapp.repositories.rides.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        return rideRepository.findById(id).get();
    }

    @Override
    public Ride updateRide(Ride ride, String id) {
        Ride rideToUpdate = rideRepository.findById(id).get();
        rideToUpdate.updateRide(ride);
        return rideRepository.save(rideToUpdate);
    }

    @Override
    public Ride deleteRide(String id) {
        Ride ride = rideRepository.findById(id).get();
        ride.setIsActive(false);
        return ride;
    }

    @Override
    public List<Ride> getAllArrivalDate(String arrival_date) throws ParseException {
        List<Ride> rides = new ArrayList<>();
        Date date = convertStringDate(arrival_date);
        for(Ride ride: getAllRides()) {
            if (ride.getHourArrival().getYear()==date.getYear() && ride.getHourArrival().getMonth()==date.getMonth() && ride.getHourArrival().getDate()==date.getDate() && ride.getHourArrival().getHours()==date.getHours()) {
                rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getAllDepartureDate(String departure_date) throws ParseException {
        List<Ride> rides = new ArrayList<>();
        Date date = convertStringDate(departure_date);
        for(Ride ride: getAllRides()) {
            if (ride.getHourDeparture().getYear()==date.getYear() && ride.getHourDeparture().getMonth()==date.getMonth() && ride.getHourDeparture().getDate()==date.getDate() && ride.getHourDeparture().getHours()==date.getHours()) {
                rides.add(ride);
            }
        }
        return rides;
    }

    @Override
    public List<Ride> getAllSeatsDate(Integer seats_available) {
        List<Ride> rides = new ArrayList<>();
        for(Ride ride: getAllRides()) {
            if (seats_available <= ride.getAvailableSeats()) {
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
                if(keyword.equals(keyw)) {
                    rides.add(ride);
                }
            }
        }
        return rides;
    }

    @Override
    public Ride postReserveJourney(JourneyDto journeyDto) {
        Ride ride = rideRepository.findById(JourneyDto.getIdRide()).get();
        ArrayList<String> passenger = ride.getListPassenger();
        ArrayList<String> stops = ride.getListStops();
        if (journeyDto.getSeats() <= ride.getAvailableSeats()) {
            if(journeyDto.getSeats() != journeyDto.getListSeatsStop().size()) {
                return ride;
            }
            for (int i = 0; i<journeyDto.getSeats(); i++) {
                passenger.add(journeyDto.getIdUser());
            }
            stops.addAll(journeyDto.getListSeatsStop());
        }
        return setRice(ride, passenger, stops, ride.getAvailableSeats()-journeyDto.getSeats());
    }

    @Override
    public Ride deleteReserve(String idRide, String idUser) {
        Ride ride = rideRepository.findById(idRide).get();
        int numPassenger = ride.getListPassenger().size();
        ArrayList<String> lisPassenger = ride.getListPassenger();
        ArrayList<String> lisStops = ride.getListStops();
        ArrayList<Integer> con = new ArrayList<>();
        for (int i = 0; i<numPassenger; i++ ) {
            if (lisPassenger.get(i).equals(idUser)) {
                con.add(i);
            }
        }
        numPassenger=+ride.getAvailableSeats()+numPassenger;
        for (int i=con.size()-1;i>=0;i--) {
            lisPassenger.remove(i);
            lisStops.remove(i);
        }
        return setRice(ride, lisPassenger, lisStops, numPassenger);
    }

    @Override
    public Ride putReserveJourney(JourneyDto journeyDto) {
        Ride ride = rideRepository.findById(JourneyDto.getIdRide()).get();
        ArrayList<String> lisPassenger = ride.getListPassenger();
        int con = 0;
        for (String idPassenger: lisPassenger) {
            if(idPassenger.equals(journeyDto.getIdUser())) {
                con++;
            }
        }
        if(journeyDto.getSeats()-con > ride.getAvailableSeats()) {
            return ride;
        }
        for (int i = journeyDto.getSeats(); i>con; i--) {
            ride.addListPassenger(journeyDto.getIdUser());
            ride.addListStop(journeyDto.getListSeatsStop().get(i-1));
            ride.setAvailableSeats(ride.getAvailableSeats()-1);
        }
        rideRepository.save(ride);
        return ride;
    }

    public Date convertStringDate(String dateS) throws ParseException {
        SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter6.parse(dateS));
        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR)-5);
        return cal.getTime();
    }

    public Ride setRice(Ride ride, ArrayList<String> lisPassenger, ArrayList<String> lisStops, Integer numPassenger) {
        ride.setListPassenger(lisPassenger);
        ride.setListStops(lisStops);
        ride.setAvailableSeats(numPassenger);
        rideRepository.save(ride);
        return ride;
    }
}
