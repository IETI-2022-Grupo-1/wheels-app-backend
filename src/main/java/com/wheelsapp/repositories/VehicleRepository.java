package com.wheelsapp.repositories;


import com.wheelsapp.entities.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {
}
