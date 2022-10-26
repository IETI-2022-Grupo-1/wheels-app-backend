package com.wheelsapp.controllers.constants;

import com.wheelsapp.dto.constants.CityDTO;
import com.wheelsapp.dto.constants.DepartamentDTO;
import com.wheelsapp.services.constants.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/constants")
public class DepartamentController {

    private final DepartamentService departamentService;

    public DepartamentController(@Autowired DepartamentService departamentService){
        this.departamentService = departamentService;
    }
    @GetMapping("/colombia")
    public ResponseEntity<List<DepartamentDTO>> getAll(){
        return new ResponseEntity<>(departamentService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/departments/{name}")
    public ResponseEntity<List<CityDTO>> getAllCitiesByDepartament(@PathVariable String name){
        return new ResponseEntity<>(departamentService.getAllCitiesByDepartament(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<String>> getAllDepartaments(){
        return new ResponseEntity<>(departamentService.getAllDepartaments(), HttpStatus.ACCEPTED);
    }


    @GetMapping("/cities")
    public ResponseEntity<List<String>> getAllCities(){
        return new ResponseEntity<>(departamentService.getAllCities(), HttpStatus.ACCEPTED);
    }

}