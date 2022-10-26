package com.wheelsapp.dto.constants;

import lombok.Data;

import java.util.List;
@Data
public class DepartamentDTO{
    private String name;
    public List<CityDTO> cities;

    public DepartamentDTO(String name, List<CityDTO> cities){
        this.name = name;
        this.cities = cities;
    }

    public DepartamentDTO(){

    }

}