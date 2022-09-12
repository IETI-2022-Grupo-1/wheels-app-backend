package com.wheelsapp.services.organizations;

import com.wheelsapp.entities.organizations.Ciudad;
import com.wheelsapp.entities.organizations.Departamento;
import com.wheelsapp.entities.organizations.Organization;
import com.wheelsapp.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceMongo implements OrganizationService,DepartamentoService,CiudadesService{

    private final OrganizationService organizationService;
    private final CiudadesService ciudadesService;
    private final DepartamentoService departamentoService;
    public OrganizationServiceMongo(@Autowired OrganizationService organizationService,@Autowired CiudadesService ciudadesService,
                                     @Autowired DepartamentoService departamentoService){
        this.organizationService = organizationService;
        this.ciudadesService = ciudadesService;
        this.departamentoService = departamentoService;
    }

    @Override
    public Organization create(Organization organization) {
        return null;
    }

    @Override
    public Organization findById(String id) {
        return null;
    }

    @Override
    public List<Organization> getAll() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public Organization update(Organization organization, String userId) {
        return null;
    }

    @Override
    public List<Departamento> getAllDepartaments() {
        return null;
    }


    @Override
    public List<Ciudad> getAllCitys() {
        return null;
    }
}
