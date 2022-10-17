package com.wheelsapp.services.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import com.wheelsapp.entities.constants.City;
import com.wheelsapp.entities.constants.Departament;
import com.wheelsapp.entities.organizations.Organization;
import com.wheelsapp.exception.ExceptionGenerator;
import com.wheelsapp.exception.ExceptionType;
import com.wheelsapp.repositories.organizations.OrganizationRepository;
import com.wheelsapp.services.constants.DepartamentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceMongo implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    private final DepartamentService departamentService;
    public OrganizationServiceMongo(@Autowired OrganizationRepository organizationRepository, @Autowired DepartamentService departamentService
            , @Autowired ModelMapper modelMapper){
        this.organizationRepository = organizationRepository;
        this.modelMapper = modelMapper;
        this.departamentService = departamentService;
    }

    @Override
    public OrganizationDTO create(OrganizationDTO organizationDTO) {
        Optional<Organization> organizationd = organizationRepository.findByNIT(organizationDTO.getNIT());
        if(!(organizationd.isPresent())){
            Departament departament = departamentService.findDepartamentByName(organizationDTO.getDepartament());
            City city = departamentService.findCityByName(organizationDTO.getCity(),departament);
            Organization organization = new Organization(organizationDTO,departament,city);
            organizationRepository.save(organization);
            return modelMapper.map(organization, OrganizationDTO.class);
        }
        throw ExceptionGenerator.getException(ExceptionType.DUPLICATE_ENTITY, "NIT already in use");
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
        Organization organization = findById(userId);
        organization.updateOrganization(organizationDTO);
        organizationRepository.save(organization);
        return modelMapper.map(organization,OrganizationDTO.class);
    }


}