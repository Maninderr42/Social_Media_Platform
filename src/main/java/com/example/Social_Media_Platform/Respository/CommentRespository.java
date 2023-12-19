package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Models.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRespository extends MongoRepository<Comments ,Integer> {
}
