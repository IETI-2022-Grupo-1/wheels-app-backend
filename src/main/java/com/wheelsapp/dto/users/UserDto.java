package com.wheelsapp.dto.users;

import com.wheelsapp.utils.RoleEnum;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura Garcia
 */
public class UserDto {
    private String id;
    private String city;
    @Size(max=40)
    private String name;
    @Size(max=60)
    private String lastName;
    @Size(max=120)
    private String email;
    private String password;
    private boolean isActive;
    private String phoneNumber;
    private String organization;
    private String profilePhoto;
    private List<RoleEnum> roles = new ArrayList<>();

    public UserDto(String id, String name, String lastName, String email, String password, String phoneNumber, String city, String organization, String profilePhoto) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.organization = organization;
        this.profilePhoto = profilePhoto;
    }

    public UserDto(){};

    public String getId() {return id;}

    public void setId(String id) { this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }
}
