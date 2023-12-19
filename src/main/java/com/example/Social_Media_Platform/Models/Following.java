package com.example.Social_Media_Platform.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Following", collation = "{ 'locale': 'en' }")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Following {

    @Id
    private Integer FollowingId;
    private Integer noOfFollower;
    private User send;
    private User followingUser;
}
