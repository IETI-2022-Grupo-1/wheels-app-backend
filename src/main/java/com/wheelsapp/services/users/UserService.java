package com.wheelsapp.services.users;

import com.wheelsapp.entities.users.User;

import java.util.List;

/**
 * @author Laura Garcia
 */
public interface UserService {
    User createUser(User user);

    User findById(String userId);

    List<User> getAll();

    User deleteUser(String userId);

    User updateUser(User user, String userId);

}
