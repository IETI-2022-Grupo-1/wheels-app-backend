package com.wheelsapp.dto.cars;

public class VehicleDto {
    private String idUser;
    private String model;
    private String soat;
    private Integer puestos;
    private String propertyCard;
    private String description;
    private String photo;
    private boolean isActive;

    public VehicleDto(String idUser, String model, String soat, Integer puestos, String propertyCard, String description, String photo, boolean isActive) {
        this.idUser = idUser;
        this.model = model;
        this.soat = soat;
        this.puestos = puestos;
        this.propertyCard = propertyCard;
        this.description = description;
        this.photo = photo;
        this.isActive = isActive;
    }
    public VehicleDto(){

    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public Integer getPuestos() {
        return puestos;
    }

    public void setPuestos(Integer puestos) {
        this.puestos = puestos;
    }

    public String getPropertyCard() {
        return propertyCard;
    }

    public void setPropertyCard(String propertyCard) {
        this.propertyCard = propertyCard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
