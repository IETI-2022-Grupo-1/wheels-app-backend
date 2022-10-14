package com.wheelsapp.repositories.constants;

import com.wheelsapp.entities.constants.City;
import com.wheelsapp.entities.constants.Departament;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartamentRepository extends MongoRepository<Departament, String> {
    public Departament findByName(String name);

    public List<City> findByCities(String name);
}
