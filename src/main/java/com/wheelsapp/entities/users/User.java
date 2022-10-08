package com.wheelsapp.entities.users;

import com.wheelsapp.entities.organizations.Organization;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.time.Instant;
import java.util.ArrayList;
import com.wheelsapp.utils.RoleEnum;
import com.wheelsapp.dto.users.UserDto;
import com.wheelsapp.dto.users.UserAdminDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Laura Garcia
 */
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String city;
    @Indexed(unique = true)
    private String email;
    private Date createdAt;
    private String lastName;
    private Date lastUpdate;
    private String password;
    private boolean isActive;
    private String phoneNumber;
    private String organization;
    private String profilePhoto;
    private List<RoleEnum> roles = new ArrayList<>();

    public User(){
        this.createdAt = Date.from(Instant.now());
        this.lastUpdate = Date.from(Instant.now());
        addRole(RoleEnum.PASSENGER);
        this.isActive = true;
    }

    //User Passenger
    public User(String name, String lastName, String email, String password, String phoneNumber, String city, String profilePhoto, String organization) {
        this();
        this.city = city;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.organization = organization;
        this.profilePhoto = profilePhoto;
        addRole(RoleEnum.PASSENGER);
        hashAttributes(phoneNumber, password);
    }

    //User Admin
    public User(String name, String lastName, String email, String password, String phoneNumber){
        this();
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        addRole(RoleEnum.ADMIN);
        hashAttributes(phoneNumber, password);
    }

    public User(UserDto userDto, Organization organization){
        this(userDto.getName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword(), userDto.getPhoneNumber(), userDto.getCity(), userDto.getProfilePhoto(), userDto.getOrganization());
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

    public void updateUser(UserDto userDto){
        city = userDto.getCity();
        profilePhoto = userDto.getProfilePhoto();
        lastUpdate = Date.from(Instant.now());
        hashAttributes(userDto.getPhoneNumber(), userDto.getPassword());
    }
}
