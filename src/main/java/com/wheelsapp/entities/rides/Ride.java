package com.wheelsapp.entities.rides;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.wheelsapp.dto.rides.RideDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

    public Ride(){}

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

    public void updateRide(Ride ride){
        id = ride.getId();
        idDriver = ride.getIdDriver();
        route = ride.getRoute();
        journeyDate = ride.getJourneyDate();
        departureHour = ride.getDepartureHour();
        arrivalHour = ride.getArrivalHour();
        availableSeats = ride.getAvailableSeats();
        seatsReserved = ride.getSeatsReserved();
        isActive = ride.getIsActive();
        hasStarted = ride.getHasStarted();
        passengerList = ride.getPassengerList();
        stopsList = ride.getStopsList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(String idDriver) {
        this.idDriver = idDriver;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Date getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(Date departureHour) {
        this.departureHour = departureHour;
    }

    public Date getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(Date arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public ArrayList<String> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<String> route) {
        this.route = route;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(Integer seatsReserved) {
        this.seatsReserved = seatsReserved;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {this.isActive = isActive;}

    public Boolean getHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(Boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ArrayList<String> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<String> passengerList) {
        this.passengerList = passengerList;
    }

    public HashMap<String, String> getStopsList() {
        return stopsList;
    }

    public void setStopsList(HashMap<String, String> stopsList) {
        this.stopsList = stopsList;
    }

    public void addListPassenger(String s) {
        this.passengerList.add(s);
    }
}
