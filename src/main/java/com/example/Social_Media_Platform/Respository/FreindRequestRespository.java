package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Enum.FriendshipStatus;
import com.example.Social_Media_Platform.Models.FriendRequest;
import com.example.Social_Media_Platform.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FreindRequestRespository  extends MongoRepository<FriendRequest, Integer> {

}
