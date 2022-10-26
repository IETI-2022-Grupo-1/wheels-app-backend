package com.wheelsapp.repositories.users;

import java.util.Optional;
import com.wheelsapp.entities.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Laura Garcia
 */
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String userId);

    Optional<User> findByEmail(String email);
}
