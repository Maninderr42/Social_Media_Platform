package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Models.Following;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FollowingRespository extends MongoRepository<Following, Integer> {
}
