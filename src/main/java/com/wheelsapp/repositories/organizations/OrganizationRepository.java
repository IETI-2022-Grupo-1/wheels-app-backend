package com.wheelsapp.repositories.organizations;

import com.wheelsapp.entities.organizations.Ciudad;
import com.wheelsapp.entities.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends MongoRepository<User, String> {

    List<Ciudad> getAllCitys();

}
