package com.wheelsapp.entities.cars;

import com.wheelsapp.dto.cars.VehicleDto;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
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

    public Vehicle(String idUser, String model, String soat, Integer puestos, String propertyCard, String description, String photo, boolean isActive) {
        this.idUser = idUser;
        this.model = model;
        this.soat = soat;
        this.puestos = puestos;
        this.propertyCard = propertyCard;
        this.description = description;
        this.photo = photo;
        this.isActive = isActive;
        this.createdAt = new Date();
        this.lastUpdate = new Date();
    }
    public Vehicle(VehicleDto vehicleDto){
        this.description=vehicleDto.getDescription();
        this.isActive=vehicleDto.getIsActive();
        this.model=vehicleDto.getModel();
        this.idUser=vehicleDto.getIdUser();
        this.soat = vehicleDto.getSoat() ;
        this.puestos = vehicleDto.getPuestos();
        this.propertyCard=vehicleDto.getPropertyCard();
        this.photo=vehicleDto.getPhoto();
        this.lastUpdate= new Date();
        this.createdAt = new Date();

    }


    public boolean getIsActive() {
        return isActive;
}

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void update(Vehicle vehicle){
        this.description=vehicle.getDescription();
        this.isActive=vehicle.getIsActive();
        this.model=vehicle.getModel();
        this.idUser=vehicle.getIdUser();
        this.soat = vehicle.getSoat() ;
        this.puestos = vehicle.getPuestos();
        this.propertyCard=vehicle.getPropertyCard();
        this.photo=vehicle.getPhoto();
        this.lastUpdate= new Date();
    }
}
