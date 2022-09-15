package com.wheelsapp.services.users;


import com.wheelsapp.entities.users.User;
import com.wheelsapp.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Laura Garcia
 */
@Service
public class UserServiceMongo implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongo(@Autowired UserRepository userRepository ){
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUser(String userId) {
        User user = findById(userId);
        user.setActive(false);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user, String userId) {
        User userToUpdate = findById(userId);
        userToUpdate.updateUser(user);
        return userRepository.save(userToUpdate);
    }

}
