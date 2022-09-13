package com.wheelsapp.repositories.organizations;

import com.wheelsapp.entities.organizations.City;
import com.wheelsapp.entities.organizations.Departament;
import com.wheelsapp.entities.organizations.Organization;
import com.wheelsapp.entities.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

}
