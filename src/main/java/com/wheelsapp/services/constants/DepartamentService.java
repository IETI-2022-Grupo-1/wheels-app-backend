package com.wheelsapp.services.constants;

import com.wheelsapp.dto.constants.CityDTO;
import com.wheelsapp.dto.constants.DepartamentDTO;

import java.util.List;

public interface DepartamentService {

    public List<DepartamentDTO> getAll();


    public List<CityDTO> getAllCitiesByDepartament(String name);

    public List<String> getAllCities();

    public List<String> getAllDepartaments();

}
