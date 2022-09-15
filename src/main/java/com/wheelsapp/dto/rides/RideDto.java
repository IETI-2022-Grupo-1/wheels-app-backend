package com.wheelsapp.dto.rides;

import java.util.ArrayList;
import java.util.Date;

/*
* @author Julian Peña
*/
public class RideDto {
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
    private ArrayList<String> stopsList;

    public RideDto(){}

    public RideDto(String idDriver, String idCar, Date journeyDate, Date departureHour, Date arrivalHour, ArrayList<String> route, Integer availableSeats, Integer seatsReserved, Boolean isActive, Boolean hasStarted, Integer code, ArrayList<String> passengerList, ArrayList<String> stopsList) {
        this.idDriver = idDriver;
        this.idCar = idCar;
        this.journeyDate = journeyDate;
        this.departureHour = departureHour;
        this.arrivalHour = arrivalHour;
        this.route = route;
        this.availableSeats = availableSeats;
        this.seatsReserved = seatsReserved;
        this.isActive = isActive;
        this.hasStarted = hasStarted;
        this.code = code;
        this.passengerList = passengerList;
        this.stopsList = stopsList;
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

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    public ArrayList<String> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<String> passengerList) {
        this.passengerList = passengerList;
    }

    public ArrayList<String> getStopsList() {
        return stopsList;
    }

    public void setStopsList(ArrayList<String> stopsList) {
        this.stopsList = stopsList;
    }
}
