package com.wheelsapp.services.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import com.wheelsapp.entities.organizations.Organization;

import java.util.List;

public interface OrganizationService {

    OrganizationDTO create(OrganizationDTO organization);

    OrganizationDTO findByIdDto(String id);

    Organization findById(String id);

    List<OrganizationDTO> getAll();

    OrganizationDTO deleteById(String id);

    OrganizationDTO update(OrganizationDTO organization, String userId);
}
