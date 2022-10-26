package com.wheelsapp.dto.rides;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/*
 * @author Julian Peña
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDto {
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

}
