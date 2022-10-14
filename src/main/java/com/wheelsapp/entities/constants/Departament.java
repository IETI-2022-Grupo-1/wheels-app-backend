package com.wheelsapp.entities.constants;

import com.wheelsapp.entities.constants.City;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "departaments")
public class Departament {
    @Id
    private String id;
    private String name;
    public List<City> cities;

    public String selected;
    public Departament(String name, List<City> cities){
        this.name = name;
        this.cities = cities;
    }



}


