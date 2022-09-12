package com.wheelsapp.dto.rides;

import java.util.ArrayList;
import java.util.Date;

/*
* @author Julian Peña
*/
public class rideDto {
    private String idDriver;
    private String idCar;
    private Date journeyDate;
    private Date houDeparture;
    private Date hourArrival;
    private ArrayList<String> route;
    private Integer availableSeats;
    private Integer seatsReserve;
    private Boolean isActive;
    private Boolean hasStarted;
    private Integer code;
    private ArrayList<String> listPassenger;
    private ArrayList<String> listStops;

    public rideDto(){}

    public rideDto(String idDriver, String idCar, ArrayList<String> route, Integer availableSeats, Integer seatsReserve, Boolean isActive, Boolean hasStarted, Integer code, ArrayList<String> listPassenger, ArrayList<String> listStops) {
        this.idDriver = idDriver;
        this.idCar = idCar;
        this.route = route;
        this.availableSeats = availableSeats;
        this.seatsReserve = seatsReserve;
        this.isActive = isActive;
        this.hasStarted = hasStarted;
        this.code = code;
        this.listPassenger = listPassenger;
        this.listStops = listStops;
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

    public Date getHourDeparture() {
        return houDeparture;
    }

    public void setHourDeparture(Date hourDeparture) {
        this.houDeparture = hourDeparture;
    }

    public Date getHourArrival() {
        return hourArrival;
    }

    public void setHourArrival(Date hourArrival) {
        this.hourArrival = hourArrival;
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

    public Integer getSeatsReserve() {
        return seatsReserve;
    }

    public void setSeatsReserve(Integer seatsReserve) {
        this.seatsReserve = seatsReserve;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

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
