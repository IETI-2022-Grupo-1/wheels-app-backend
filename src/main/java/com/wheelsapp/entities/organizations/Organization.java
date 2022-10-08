package com.wheelsapp.entities.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.Instant;
import java.util.Date;

/**
 * @author Laura Garcia
 */
public class Organization {
    @Id
    private String id;
    private String name;

    private String NIT;

    private String city;

    private String departament;

    private String phone;

    private Date createdAt;

    private Date lastUpdate;

    private boolean isActive;

    public Organization(){
        this.createdAt = Date.from(Instant.now());
        this.lastUpdate = Date.from(Instant.now());
        this.isActive = true;
    }
    // Creating Organization with all params
    public Organization(String name, String NIT, String city, String departament, String phone, Date createdAt, Date lastUpdate) {
        this();
        this.name = name;
        this.NIT = NIT;
        this.city = city;
        this.departament = departament;
        this.phone = phone;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
    }
    // Creatioón withouth createdAt and lastUpdate
    public Organization(String name, String NIT, String city, String departament, String phone) {
        this();
        this.name = name;
        this.NIT = NIT;
        this.city = city;
        this.departament = departament;
        this.phone = phone;
    }

    public Organization(OrganizationDTO organizationDTO){
        this(organizationDTO.getName(), organizationDTO.getNIT(), organizationDTO.getCity(), organizationDTO.getDepartament(),organizationDTO.getPhone());
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }



    /**
    public List<City> getCiudades() {
        return Arrays.asList(City.values());
    }



    public List<Departament> getDepartamentos() {
        return Arrays.asList(Departament.values());
    }

**/

}
