package com.wheelsapp.services.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import com.wheelsapp.entities.organizations.Organization;
import com.wheelsapp.repositories.organizations.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceMongo implements OrganizationService{

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceMongo(@Autowired OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDTO create(OrganizationDTO organizationDTO) {
        Organization organization = new Organization(organizationDTO);
        organizationRepository.save(organization);
        return organizationDTO;
    }

    @Override
    public Organization findById(String id){
        return organizationRepository.findById(id).get();
    }

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization deleteById(String id) {
        if (organizationRepository.existsById(id)){
            Organization organization = findById(id);
            organization.setActive(false);
            organizationRepository.save(organization);
            return  organization;
        }else{return  null; }

    }

    @Override
    public Organization update(Organization organization, String userId) {

        if (organizationRepository.existsById(userId)) {
            Organization oldOrganization = findById(userId);
            oldOrganization.setCity(organization.getCity());
            oldOrganization.setDepartament(organization.getDepartament());
            oldOrganization.setCreatedAt(organization.getCreatedAt());
            oldOrganization.setNIT(organization.getNIT());
            oldOrganization.setLastUpdate(organization.getLastUpdate());
            oldOrganization.setName(organization.getName());
            return organizationRepository.save(oldOrganization);
        }return null;
    }


}
