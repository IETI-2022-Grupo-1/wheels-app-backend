package com.wheelsapp.entities.rides;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Juan Cadavid
 */
public class Ride {
    @Id
    private String idRide;
    private String idUser;
    private String idCar;
    private Date journeyDate;
    private Date houDeparture;
    private Date hourArrival;
    private ArrayList<String> route;
    private Integer cost;
    private Integer availableSeats;
    private Integer seatsReserve;
    private boolean isActive;
    private boolean hasStarted;
    private Integer code;
    private ArrayList<String> listPassenger;
    private ArrayList<String> listStops;

    public Ride() {}

    public Ride(String idRide, String idUser, String idCar, Date journeyDate, Date houDeparture, Date hourArrival, ArrayList<String> route, Integer cost, Integer availableSeats, Integer seatsReserve, boolean isActive, boolean hasStarted, Integer code, ArrayList<String> listPassenger, ArrayList<String> listStops) {
        this.idRide = idRide;
        this.idUser = idUser;
        this.idCar = idCar;
        this.journeyDate = journeyDate;
        this.houDeparture = houDeparture;
        this.hourArrival = hourArrival;
        this.route = route;
        this.cost = cost;
        this.availableSeats = availableSeats;
        this.seatsReserve = seatsReserve;
        this.isActive = isActive;
        this.hasStarted = hasStarted;
        this.code = code;
        this.listPassenger = listPassenger;
        this.listStops = listStops;
    }

    public String getIdRide() {
        return idRide;
    }

    public void setIdRide(String idRide) {
        this.idRide = idRide;
    }

    public Date getHouDeparture() {
        return houDeparture;
    }

    public void setHouDeparture(Date houDeparture) {
        this.houDeparture = houDeparture;
    }

    public Date getHourArrival() {
        return hourArrival;
    }

    public void setHourArrival(Date hourArrival) {
        this.hourArrival = hourArrival;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public ArrayList<String> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<String> route) {
        this.route = route;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getSeatsReserve() {
        return seatsReserve;
    }

    public void setSeatsReserve(Integer seatsReserve) {
        this.seatsReserve = seatsReserve;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ArrayList<String> getListPassenger() {
        return listPassenger;
    }

    public void setListPassenger(ArrayList<String> listPassenger) {
        this.listPassenger = listPassenger;
    }

    public ArrayList<String> getListStops() {
        return listStops;
    }

    public void setListStops(ArrayList<String> listStops) {
        this.listStops = listStops;
    }
}
