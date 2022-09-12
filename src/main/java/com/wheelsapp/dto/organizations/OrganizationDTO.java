package com.wheelsapp.dto.organizations;

import com.wheelsapp.entities.organizations.Ciudad;
import com.wheelsapp.entities.organizations.Departamento;
import com.wheelsapp.entities.organizations.Organization;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Juan Andrés Pico
 */
public class OrganizationDTO {
    @Size(max = 150)
    private String nombre;

    @Size(max = 40)
    private String NIT;

    private CiudadDTO ciudadDTO;

    private DepartamentoDTO departamentoDTO;

    private String telefono;

    private Date createdAt;

    private Date lastUpdate;


    public OrganizationDTO(String nombre, String NIT, CiudadDTO ciudadDTO,DepartamentoDTO departamentoDTO, String telefono, Date createdAt, Date lastUpdate){
        this.nombre = nombre;
        this.NIT = NIT;
        this.ciudadDTO = ciudadDTO;
        this.departamentoDTO = departamentoDTO;
        this.telefono = telefono;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
    }

    public OrganizationDTO(){
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

    public CiudadDTO getCiudadDTO() {
        return ciudadDTO;
    }

    public void setCiudadDTO(CiudadDTO ciudadDTO) {
        this.ciudadDTO = ciudadDTO;
    }

    public DepartamentoDTO getDepartamentoDTO() {
        return departamentoDTO;
    }

    public void setDepartamentoDTO(DepartamentoDTO departamentoDTO) {
        this.departamentoDTO = departamentoDTO;
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

    public Organization changingDTOtoEntitie(OrganizationDTO organizationDTO) {
        Ciudad ciudad = organizationDTO.getCiudadDTO().changingToEntitie(organizationDTO.getCiudadDTO());
        Departamento departamento = organizationDTO.getDepartamentoDTO().changingToEntitie(organizationDTO.getDepartamentoDTO());
        Organization organization = new Organization(organizationDTO.getNombre(),organizationDTO.getNIT(),ciudad,
                departamento,organizationDTO.getTelefono(),organizationDTO.getCreatedAt(),organizationDTO.getLastUpdate());
        return organization;
    }

}
