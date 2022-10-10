package com.wheelsapp.controllers.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import com.wheelsapp.entities.organizations.Organization;
import com.wheelsapp.exception.ExceptionGenerator;
import com.wheelsapp.exception.ExceptionType;
import com.wheelsapp.services.organizations.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
        return new ResponseEntity<>(organizationService.getAll(), HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<OrganizationDTO> findById( @PathVariable String id , BindingResult bindingResult) {

        return new ResponseEntity<OrganizationDTO>(organizationService.findByIdDto(id),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody @Valid  OrganizationDTO organizationDTO,
                                                              BindingResult bindingResult) {

        if(bindingResult.hasErrors()) throw ExceptionGenerator.getException(ExceptionType.INVALID_OBJECT, "Incorrectly formed request");
        return new ResponseEntity<OrganizationDTO>(organizationService.create(organizationDTO),HttpStatus.ACCEPTED);

    }

    @PutMapping( "/{id}" )
    public ResponseEntity<OrganizationDTO> update( @RequestBody OrganizationDTO organizationDTO,
                                                   @PathVariable String id,BindingResult bindingResult ) {
        if(bindingResult.hasErrors()) throw ExceptionGenerator.getException(ExceptionType.INVALID_OBJECT, "Incorrectly formed request");
        return new ResponseEntity<OrganizationDTO>(organizationService.update(organizationDTO,id),HttpStatus.ACCEPTED) ;
    }

   // @RolesAllowed("ADMIN")
    @DeleteMapping( "/{id}" )
    public ResponseEntity<OrganizationDTO> delete( @PathVariable String id ) {
        return new ResponseEntity<OrganizationDTO>(organizationService.deleteById(id),HttpStatus.ACCEPTED)  ;
    }






}
