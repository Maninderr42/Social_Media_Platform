package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends MongoRepository<User, Integer> {

    // find name in database using customzie query
    Optional<User> findUserByUsername(String username);

    //find email in database using customzie query
    Optional<User> findEmailByEmail(String email);
}
