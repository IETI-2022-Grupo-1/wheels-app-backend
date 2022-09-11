package com.wheelsapp.repositories.users;

import com.wheelsapp.entities.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Laura Garcia
 */
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(String userId);
}
