package com.example.Social_Media_Platform.Models;


import com.example.Social_Media_Platform.Enum.FriendshipStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "FriendRequest", collation = "{ 'locale': 'en' }")
@AllArgsConstructor
@NoArgsConstructor

public class FriendRequest {

    private Integer FriendRequestId;

    private User senderRequest;

    private User reciverRequest;

    private FriendshipStatus status;
}
