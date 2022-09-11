package com.wheelsapp.entities.users;

import com.wheelsapp.dto.users.UserAdminDto;
import com.wheelsapp.dto.users.UserDto;
import com.wheelsapp.utils.RoleEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Laura Garcia
 */
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;//max 40
    private String lastName; //max 60
    @Indexed(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    private String city;
    private String organization;
    private String profilePhoto;
    private List<RoleEnum> roles = new ArrayList<>();
    private boolean isActive;
    private Date createdAt;
    private Date lastUpdate;

    public User(){
        this.createdAt = Date.from(Instant.now());
        this.lastUpdate = Date.from(Instant.now());
        addRole(RoleEnum.PASSENGER);
        this.isActive = true;
    };

    //User Passenger
    public User(String name, String lastName, String email, String password, String phoneNumber, String city, String organization, String profilePhoto) {
        this();
        System.out.println("CREATE USER");
        this.city = city;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.organization = organization;
        this.profilePhoto = profilePhoto;
        addRole(RoleEnum.PASSENGER);
        hashAttributes(phoneNumber, password);
    }

//    //User Admin
    public User(String name, String lastName, String email, String password, String phoneNumber){
        this();
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        addRole(RoleEnum.ADMIN);
        hashAttributes(phoneNumber, password);
    }

    public User(UserDto userDto){
        this(userDto.getName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword(), userDto.getPhoneNumber(), userDto.getCity(), userDto.getOrganization(), userDto.getProfilePhoto());
    }

    public User(UserAdminDto userAdminDto){
        this(userAdminDto.getName(), userAdminDto.getLastName(), userAdminDto.getEmail(), userAdminDto.getPassword(), userAdminDto.getPhoneNumber());
    }

    private void hashAttributes(String phoneNumber, String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.phoneNumber = BCrypt.hashpw(phoneNumber, BCrypt.gensalt());
    }

    public void addRole(RoleEnum role){
        if(!roles.contains(role)){
            roles.add(role);
        }
    }

    public void updateUser(User user){
        name = user.getName();
        lastName = user.getLastName();
        email = user.getEmail();
        hashAttributes(user.phoneNumber, user.password);
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

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
}
