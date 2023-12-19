package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Models.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Posts, Integer> {
}
