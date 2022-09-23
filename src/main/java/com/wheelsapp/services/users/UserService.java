package com.wheelsapp.services.users;

import java.util.List;
import com.wheelsapp.dto.users.UserDto;
import com.wheelsapp.entities.users.User;
import com.wheelsapp.dto.users.UserAdminDto;

/**
 * @author Laura Garcia
 */
public interface UserService {
    UserDto createUser(UserDto userDto);

    UserAdminDto createAdmin(UserAdminDto userAdminDto);

    UserDto createDriver(String userId);

    User findById(String userId);

    UserDto findUserDtoById(String userId);

    User findByEmail(String email);

    List<UserDto> getAll();

    UserDto deleteUser(String userId);

    UserDto updateUser(UserDto userDto, String userId);

}
