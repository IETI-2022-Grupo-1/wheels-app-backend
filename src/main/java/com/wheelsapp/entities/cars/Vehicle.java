package com.wheelsapp.entities.cars;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.Date;

@Document(collection ="cars")
public class Vehicle {
    private String idUser;

    @Id

    private String idVehicle;
    private String model;
    private String soat;
    private Integer puestos;
    private String propertyCard;
    private String description;
    private String photo;
    private boolean isActive;
    private Date createdAt;
    private Date lastUpdate;


    public Vehicle(){

    }

    public Vehicle(String idUser, String idVehicle, String model, String soat, Integer puestos, String propertyCard, String description, String photo, boolean isActive, Date createdAt, Date lastUpdate) {
        this.idUser = idUser;
        this.idVehicle = idVehicle;
        this.model = model;
        this.soat = soat;
        this.puestos = puestos;
        this.propertyCard = propertyCard;
        this.description = description;
        this.photo = photo;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
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

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
