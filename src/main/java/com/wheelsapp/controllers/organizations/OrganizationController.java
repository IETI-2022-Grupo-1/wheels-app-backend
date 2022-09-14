package com.wheelsapp.controllers.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import com.wheelsapp.entities.organizations.Organization;
import com.wheelsapp.services.organizations.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura Garcia
 */

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(@Autowired OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Organization> organizations = organizationService.getAll();
        List<OrganizationDTO> organizationDTOS = new ArrayList<>();
        for (Organization organization : organizations) {
            OrganizationDTO organizationDTO = modelMapper.map(organization, OrganizationDTO.class);
            organizationDTOS.add(organizationDTO);
        }
        return new ResponseEntity<>(organizationDTOS, HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<OrganizationDTO> findById( @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        Organization organization = organizationService.findById(id);
        OrganizationDTO organizationDTO = modelMapper.map(organization, OrganizationDTO.class);
        return new ResponseEntity<OrganizationDTO>(organizationDTO,HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> createUser(@RequestBody @Valid OrganizationDTO organizationDTO) {


        ModelMapper modelMapper = new ModelMapper();
        try {
            Organization organization = new Organization(organizationDTO.getName(), organizationDTO.getNIT(), organizationDTO.getCity(),
                    organizationDTO.getDepartament(), organizationDTO.getPhone(), organizationDTO.getCreatedAt(),
                    organizationDTO.getLastUpdate());
            organizationService.create(organization);
            organizationDTO = modelMapper.map(organization, OrganizationDTO.class);
            return new ResponseEntity<>(organizationDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<OrganizationDTO> update( @RequestBody OrganizationDTO organizationDTO, @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        Organization organization = new Organization(organizationDTO.getName(), organizationDTO.getNIT(), organizationDTO.getCity(),
                organizationDTO.getDepartament(), organizationDTO.getPhone(), organizationDTO.getCreatedAt(),
                organizationDTO.getLastUpdate());
        Organization organization2 = organizationService.update(organization,id);
        organizationDTO = modelMapper.map(organization2, OrganizationDTO.class);
        return new ResponseEntity<OrganizationDTO>(organizationDTO,HttpStatus.ACCEPTED) ;
    }

   // @RolesAllowed("ADMIN")
    @DeleteMapping( "/{id}" )
    public ResponseEntity<OrganizationDTO> delete( @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        Organization organization = organizationService.deleteById(id);
        organization.setActive(false);
        OrganizationDTO organizationDTO = modelMapper.map(organization, OrganizationDTO.class);
        return new ResponseEntity<OrganizationDTO>(organizationDTO,HttpStatus.ACCEPTED)  ;
    }






}
