package com.wheelsapp.entities.organizations;

import com.wheelsapp.dto.organizations.CiudadDTO;
import com.wheelsapp.dto.organizations.DepartamentoDTO;
import com.wheelsapp.dto.organizations.OrganizationDTO;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Laura Garcia
 */
public class Organization {

    private String nombre;
    @Id
    private String NIT;

    private Ciudad ciudad;

    private Departamento departamento;

    private String telefono;

    private Date createdAt;

    private Date lastUpdate;


    public Organization(String nombre, String NIT, Ciudad ciudad, Departamento departamento, String telefono, Date createdAt, Date lastUpdate) {
        this.nombre = nombre;
        this.NIT = NIT;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.telefono = telefono;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
    }

    public Organization() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }



    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public OrganizationDTO changingEntitieToDTO(Organization organization) {
        CiudadDTO ciudadDTO = organization.getCiudad().changingToDTO(organization.getCiudad());
        DepartamentoDTO departamentoDTO = organization.getDepartamento().changingToDTO(organization.getDepartamento());
        OrganizationDTO organizationDTO = new OrganizationDTO(organization.getNombre(), organization.getNIT(), ciudadDTO,
                departamentoDTO, organization.telefono, organization.createdAt, organization.lastUpdate);
        return organizationDTO;
    }

}
