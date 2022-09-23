package com.wheelsapp.dto.users;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;
import com.wheelsapp.utils.RoleEnum;
import javax.validation.constraints.Size;

/**
 * @author Laura Garcia
 */
@Data
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
}
