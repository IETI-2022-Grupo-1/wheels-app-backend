package com.wheelsapp.dto.constants;

import lombok.Data;

@Data
public class CityDTO {

    private String name;

    public CityDTO(String name){
        this.name = name;
    }

    public CityDTO(){

    }
}
