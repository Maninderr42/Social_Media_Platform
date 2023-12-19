package com.example.Social_Media_Platform.Service;


import com.example.Social_Media_Platform.Enum.FriendshipStatus;
import com.example.Social_Media_Platform.Exception.NotFoundException;
import com.example.Social_Media_Platform.Models.FriendRequest;
import com.example.Social_Media_Platform.Models.User;
import com.example.Social_Media_Platform.RequestDTO.AddFriendRequest;
import com.example.Social_Media_Platform.Respository.FreindRequestRespository;
import com.example.Social_Media_Platform.Respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FriendService {

    @Autowired
    private FreindRequestRespository freindRequestRespository;

    @Autowired
    private UserRespository userRespository;


    public void sendFriendRequest(AddFriendRequest addFriendRequest) throws Exception{


        Optional<User> userSender = userRespository.findById(addFriendRequest.getSenderId());

        if(userSender.isEmpty()){
            throw new NotFoundException("user not found");
        }
        User sender=userSender.get();


        Optional<User> userReceiver = userRespository.findById(addFriendRequest.getReceiverId());


        if(userReceiver.isEmpty()){
            throw new NotFoundException("user not found");
        }

        User receiver=userReceiver.get();

        // Check if a friend request already exists

        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setSenderRequest(sender);
        friendRequest.setReciverRequest(receiver);
        friendRequest.setStatus(FriendshipStatus.PENDING);

        freindRequestRespository.save(friendRequest);

    }

    public void acceptFriendRequest(Integer requestId) throws Exception {

        Optional<FriendRequest> friendRequest = freindRequestRespository.findById(requestId);

        if (friendRequest.isEmpty()){
            throw new NotFoundException("friend not found");
        }

        FriendRequest friendRequest1=friendRequest.get();

        friendRequest1.setStatus(FriendshipStatus.ACCEPTED);
        freindRequestRespository.save(friendRequest1);

    }
}
