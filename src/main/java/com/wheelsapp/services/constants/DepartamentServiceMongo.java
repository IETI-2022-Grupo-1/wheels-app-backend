package com.wheelsapp.services.constants;

import com.wheelsapp.dto.constants.CityDTO;
import com.wheelsapp.dto.constants.DepartamentDTO;
import com.wheelsapp.entities.constants.City;
import com.wheelsapp.entities.constants.Departament;
import com.wheelsapp.repositories.constants.DepartamentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentServiceMongo implements DepartamentService {

    private DepartamentRepository departamentRepository;
    private ModelMapper modelMapper;
    public DepartamentServiceMongo(@Autowired DepartamentRepository departamentRepository, @Autowired ModelMapper modelMapper){
        this.departamentRepository = departamentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DepartamentDTO> getAll(){
        List<Departament> departament = departamentRepository.findAll();
        List<DepartamentDTO> departamentDTOS = new ArrayList<>();
        for(int i = 0; i<departament.size();i++){
            departamentDTOS.add(modelMapper.map(departament.get(i),DepartamentDTO.class));
        }

        return  departamentDTOS;
    }

    @Override
    public List<CityDTO> getAllCitiesByDepartament(String name){
        List<Departament> departaments = departamentRepository.findAll();
        List<City> cities = new ArrayList<>();
        for(int i = 0 ; i<departaments.size();i++){
            if(departaments.get(i).getName().equals(name)){
                cities = departaments.get(i).getCities();
            }
        }
        return cities.stream()
                .map(city -> {
                    return modelMapper.map(city, CityDTO.class);
                }).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllCities() {
        List<String>strings = new ArrayList<>();
        List<Departament> departaments = departamentRepository.findAll();
        for(int i = 0 ; i<departaments.size();i++){
            List<City> cities = departaments.get(i).getCities();
            for(int j = 0 ; j<cities.size();j++){
                strings.add(cities.get(j).getName());
            }
        }
        return strings;
    }

    @Override
    public List<String> getAllDepartaments() {
        List<String>strings = new ArrayList<>();
        List<Departament> departaments = departamentRepository.findAll();
        for(int i = 0 ; i<departaments.size();i++){
            strings.add(departaments.get(i).getName());
        }
        return strings;
    }
}
