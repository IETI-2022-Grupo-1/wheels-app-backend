package com.wheelsapp.entities.organizations;

import com.wheelsapp.dto.organizations.OrganizationDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.Instant;
import java.util.Date;
@Data
//@Document(collection = "organizations")
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


    /**
    public List<City> getCiudades() {
        return Arrays.asList(City.values());
    }



    public List<Departament> getDepartamentos() {
        return Arrays.asList(Departament.values());
    }

**/

}
