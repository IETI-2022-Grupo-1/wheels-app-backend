package com.wheelsapp.services.constants;

import com.wheelsapp.dto.constants.CityDTO;
import com.wheelsapp.dto.constants.DepartamentDTO;
import com.wheelsapp.entities.constants.City;
import com.wheelsapp.entities.constants.Departament;

import java.util.List;

public interface DepartamentService {

    public List<DepartamentDTO> getAll();

    public List<CityDTO> getAllCitiesByDepartament(String name);

    public List<String> getAllCities();

    public List<String> getAllDepartaments();

    public Departament findDepartamentByName(String name);

    public City findCityByName(String name,Departament departament);

}