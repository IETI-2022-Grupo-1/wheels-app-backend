package com.wheelsapp.dto;

public class VehicleDto {
    private String idUser;

    private String idVehicle;
    private String model;
    private Integer puestos;
    private String description;
    private boolean isActive;

    public VehicleDto(String idUser, String idVehicle, String model, Integer puestos, String description, boolean isActive) {
        this.idUser = idUser;
        this.idVehicle = idVehicle;
        this.model = model;
        this.puestos = puestos;
        this.description = description;
        this.isActive = isActive;
    }

    public VehicleDto() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPuestos() {
        return puestos;
    }

    public void setPuestos(Integer puestos) {
        this.puestos = puestos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
