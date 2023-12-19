package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Models.Admin;
import com.example.Social_Media_Platform.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRespository extends MongoRepository<Admin,Integer> {


}
