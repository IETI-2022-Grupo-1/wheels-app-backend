package com.wheelsapp.dto.cars;

import lombok.Data;

@Data
public class VehicleDto {
    private String idUser;
    private String model;
    private String soat;
    private Integer puestos;
    private String propertyCard;
    private String description;
    private String photo;
    private boolean isActive;

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
