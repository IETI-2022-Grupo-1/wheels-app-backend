package com.wheelsapp.services.organizations;

import com.wheelsapp.entities.organizations.Organization;

import java.util.List;

public interface OrganizationService {

    Organization create(Organization organization);

    Organization findById(String id);

    List<Organization> getAll();

    Organization deleteById(String id);

    Organization update(Organization organization, String userId);
}