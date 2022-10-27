package com.wheelsapp.dto.cars;

import lombok.Data;


@Data
public class VehicleDto {
    private String idUser;
    private String licensePlate;
    private String model;
    private String soat;
    private Integer seats;
    private String propertyCard;
    private String description;
    private String photo;
    private boolean isActive;

}
