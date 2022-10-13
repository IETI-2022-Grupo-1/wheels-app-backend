package com.wheelsapp.services.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import com.wheelsapp.dto.users.UserDto;
import com.wheelsapp.entities.organizations.Organization;
import com.wheelsapp.entities.users.User;
import com.wheelsapp.exception.ExceptionGenerator;
import com.wheelsapp.exception.ExceptionType;
import com.wheelsapp.repositories.organizations.OrganizationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceMongo implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;
    public OrganizationServiceMongo(@Autowired OrganizationRepository organizationRepository,@Autowired ModelMapper
                                    modelMapper){
        this.organizationRepository = organizationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrganizationDTO create(OrganizationDTO organizationDTO) {
        Optional<Organization> organizationd = organizationRepository.findByNIT(organizationDTO.getNIT());
        if(!(organizationd.isPresent())){
            Organization organization = new Organization(organizationDTO);
            organizationRepository.save(organization);
            return modelMapper.map(organization, OrganizationDTO.class);
        }
        throw ExceptionGenerator.getException(ExceptionType.DUPLICATE_ENTITY, "Invalid Credentials");
    }

    @Override
    public OrganizationDTO findByIdDto(String id){
        return modelMapper.map(findById(id),OrganizationDTO.class);
    }

    @Override
    public Organization findById(String id) {
        Optional<Organization> searching = organizationRepository.findById(id);
        if(searching.isPresent()){
            return searching.get();
        }
        throw ExceptionGenerator.getException(ExceptionType.NOT_FOUND, "Organization not found");
    }

    @Override
    public List<OrganizationDTO> getAll() {
        List<Organization> organizations =  organizationRepository.findAll();
        List<OrganizationDTO> organizationDTOS = new ArrayList<>();
        for(int i = 0; i<organizations.size();i++){
            organizationDTOS.add(modelMapper.map(organizations.get(i),OrganizationDTO.class));
        }
        return organizationDTOS;
    }

    @Override
    public OrganizationDTO deleteById(String id) {
        if (organizationRepository.existsById(id)){
            Organization organization = findById(id);
            organization.setActive(false);
            organizationRepository.save(organization);
            return  modelMapper.map(organization,OrganizationDTO.class);
        }
        throw ExceptionGenerator.getException(ExceptionType.NOT_FOUND, "Organization not found");
    }

    @Override
    public OrganizationDTO update(OrganizationDTO organizationDTO, String userId) {
        if (organizationRepository.existsById(userId)) {
            Organization oldOrganization = findById(userId);
            oldOrganization.setCity(organizationDTO.getCity());
            oldOrganization.setDepartament(organizationDTO.getDepartament());
            oldOrganization.setCreatedAt(organizationDTO.getCreatedAt());
            oldOrganization.setNIT(organizationDTO.getNIT());
            oldOrganization.setLastUpdate(organizationDTO.getLastUpdate());
            oldOrganization.setName(organizationDTO.getName());
            oldOrganization.setActive(organizationDTO.isActive());
            return modelMapper.map(organizationRepository.save(oldOrganization),OrganizationDTO.class);
        }return null;
    }


}
