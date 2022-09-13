package com.wheelsapp.dto.organizations;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

/**
 * @author Juan Andrés Pico
 */
public class OrganizationDTO {
    @Size(max = 150)
    private String name;

    @Size(max = 40)
    private String NIT;

    private String city;

    private String departament;

    private String phone;

    private Date createdAt;

    private Date lastUpdate;


    public OrganizationDTO(String name, String NIT, String city, String departament, String phone, Date createdAt, Date lastUpdate){
        this();
        this.name = name;
        this.NIT = NIT;
        this.city = city;
        this.departament = departament;
        this.phone = phone;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
    }

    public OrganizationDTO(String name, String NIT, String city, String departament, String phone) {
        this();
        this.name = name;
        this.NIT = NIT;
        this.city = city;
        this.departament = departament;
        this.phone = phone;
    }

    public OrganizationDTO(){
        this.createdAt = Date.from(Instant.now());
        this.lastUpdate = Date.from(Instant.now());
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

    public void setDepartament(String departament) {
        this.departament = departament;
    }



    public String getDepartament() {
        return departament;
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
    
    // Proximamente para colección departamentos y bla bla bla 
    /**
    public List<Departament> getDepartaments() {
        return Arrays.asList(Departament.values());
    }
    public List<City> getCiudades() {
        return Arrays.asList(City.values());}**/

}
