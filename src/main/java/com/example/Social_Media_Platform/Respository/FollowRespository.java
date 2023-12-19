package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Models.Follower;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FollowRespository extends MongoRepository<Follower,Integer> {
}
