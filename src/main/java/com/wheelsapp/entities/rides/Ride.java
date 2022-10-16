package com.wheelsapp.entities.rides;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.wheelsapp.dto.rides.RideDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Data
@NoArgsConstructor
@Document(collection = "Rides")
public class Ride {
    @Id
    private String id;
    private String idDriver;
    private String idCar;
    private Date journeyDate;
    private Date departureHour;
    private Date arrivalHour;
    private ArrayList<String> route;
    private Integer availableSeats;
    private Integer seatsReserved;
    private Boolean isActive;
    private Boolean hasStarted;
    private Integer code;
    private ArrayList<String> passengerList;
    private HashMap<String, String> stopsList;

    public Ride(RideDto rideDTO) {
        this.idDriver = rideDTO.getIdDriver();
        this.idCar = rideDTO.getIdCar();
        this.journeyDate = rideDTO.getJourneyDate();
        this.arrivalHour = rideDTO.getArrivalHour();
        this.departureHour = rideDTO.getDepartureHour();
        this.route = rideDTO.getRoute();
        this.availableSeats = rideDTO.getAvailableSeats();
        this.seatsReserved = rideDTO.getSeatsReserved();
        this.isActive = rideDTO.getIsActive();
        this.hasStarted = rideDTO.getHasStarted();
        this.code = rideDTO.getCode();
        this.passengerList = rideDTO.getPassengerList();
        this.stopsList = rideDTO.getStopsList();
    }

    public void updateRide(Ride ride) {
        this.idDriver = ride.getIdDriver();
        this.route = ride.getRoute();
        this.journeyDate = ride.getJourneyDate();
        this.departureHour = ride.getDepartureHour();
        this.arrivalHour = ride.getArrivalHour();
        this.availableSeats = ride.getAvailableSeats();
        this.seatsReserved = ride.getSeatsReserved();
        this.isActive = ride.getIsActive();
        this.hasStarted = ride.getHasStarted();
        this.passengerList = ride.getPassengerList();
        this.stopsList = ride.getStopsList();
    }
}
