package com.wheelsapp.repositories.organizations;

import com.wheelsapp.entities.organizations.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
    Optional<Organization> findById(String id);

    Optional<Organization> findByNIT(String NIT);


}
