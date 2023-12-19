package com.example.Social_Media_Platform.RequestDTO;

import com.example.Social_Media_Platform.Enum.FriendshipStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFriendRequest {

    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    private FriendshipStatus status;
}
