package com.wheelsapp.services.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import com.wheelsapp.entities.organizations.Organization;

import java.util.List;

public interface OrganizationService {

    OrganizationDTO create(OrganizationDTO organization);

    Organization findById(String id);

    List<Organization> getAll();

    Organization deleteById(String id);

    Organization update(Organization organization, String userId);
}
