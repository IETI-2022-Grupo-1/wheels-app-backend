package com.wheelsapp.dto.organizations;

import com.wheelsapp.entities.constants.City;
import com.wheelsapp.entities.constants.Departament;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

/**
 * @author Juan Andrés Pico
 */
@Data
public class OrganizationDTO {
    private String id;
    @Size(max = 150)
    @Indexed(unique = true)
    private String name;

    @Size(max = 40)
    @Indexed(unique = true)
    private String NIT;

    private String city;

    private String departament;

    private String phone;

    private Date createdAt;

    private Date lastUpdate;

    private boolean isActive;


    public OrganizationDTO(String name, String NIT, String city, String departament, String phone, Date createdAt, Date lastUpdate,boolean isActive){
        this();
        this.name = name;
        this.NIT = NIT;
        this.city = city;
        this.departament = departament;
        this.phone = phone;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
        this.isActive = isActive;
    }

    public OrganizationDTO(String name, String NIT, String city, String departament, String phone) {
        this();
        this.name = name;
        this.NIT = NIT;
        this.city = city;
        this.departament = departament;
        this.phone = phone;
    }

    public OrganizationDTO(OrganizationDTO organizationDTO, Departament departament, City city){
        this(organizationDTO.getName(), organizationDTO.getNIT(), city.getName(), departament.getName(),organizationDTO.getPhone());
    }


    public OrganizationDTO(){
        this.createdAt = Date.from(Instant.now());
        this.lastUpdate = Date.from(Instant.now());
        this.isActive = true;
    }

}