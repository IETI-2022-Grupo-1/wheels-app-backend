package com.wheelsapp.dto.rides;

import java.util.ArrayList;

public class JourneyDto {
    private static String idRide;
    private String idUser;
    private Integer seats;
    private ArrayList<String> listSeatsStop;

    public JourneyDto () {}

    public JourneyDto(String idRide, String idUser, Integer seats, ArrayList<String> listSeatsStop) {
        this.idRide = idRide;
        this.idUser = idUser;
        this.seats = seats;
        this.listSeatsStop = listSeatsStop;
    }

    public static String getIdRide() {
        return idRide;
    }

    public void setIdRide(String idRide) {
        this.idRide = idRide;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public ArrayList<String> getListSeatsStop() {
        return listSeatsStop;
    }

    public void setListSeatsStop(ArrayList<String> listSeatsStop) {
        this.listSeatsStop = listSeatsStop;
    }
}
