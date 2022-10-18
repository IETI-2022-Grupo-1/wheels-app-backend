package com.wheelsapp.entities.constants;

import lombok.Data;

@Data
public class City {
    private String name;

    public City(String name){
        this.name = name;
    }
}