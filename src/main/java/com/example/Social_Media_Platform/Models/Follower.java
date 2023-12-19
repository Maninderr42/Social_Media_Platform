package com.example.Social_Media_Platform.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Follower", collation = "{ 'locale': 'en' }")

public class Follower {

    @Id
    private Integer FollowerId;
    private Integer noOfFollower;
    private User send;
    private User reciver;
}
