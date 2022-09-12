package com.wheelsapp.dto.organizations;

import com.wheelsapp.entities.organizations.Ciudad;

public class CiudadDTO {

    public String name;

    public CiudadDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ciudad changingToEntitie(CiudadDTO ciudadDTO){
        Ciudad ciudad = new Ciudad(ciudadDTO.getName());
        return ciudad;
    }
}
