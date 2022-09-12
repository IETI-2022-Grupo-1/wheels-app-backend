package com.wheelsapp.repositories.rides;

import com.wheelsapp.entities.rides.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface rideRepository extends MongoRepository<Ride, String> {
}
