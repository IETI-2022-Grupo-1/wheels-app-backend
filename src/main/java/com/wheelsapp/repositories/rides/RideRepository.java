package com.wheelsapp.repositories.rides;

import com.wheelsapp.entities.rides.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Juan Cadavid
 */
public interface RideRepository extends MongoRepository<Ride, String> {
}
