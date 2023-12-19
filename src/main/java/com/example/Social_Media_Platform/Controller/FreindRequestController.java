package com.example.Social_Media_Platform.Controller;

import com.example.Social_Media_Platform.RequestDTO.AddFriendRequest;
import com.example.Social_Media_Platform.Service.FriendService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("friendRequest")
public class FreindRequestController {

    @Autowired
    private FriendService friendService;


    @PostMapping("sendFreindRequest")
    public ResponseEntity<String> sendFriendRequest(@RequestBody AddFriendRequest addFriendRequest) throws Exception {

        friendService.sendFriendRequest(addFriendRequest);
        return ResponseEntity.ok("Friend request sent successfully");
    }

    @PutMapping("/{requestId}/accept")
    public ResponseEntity<String> acceptFriendRequest(@RequestParam Integer requestId)throws Exception {

        friendService.acceptFriendRequest(requestId);
        return ResponseEntity.ok("Friend request accepted successfully");
    }


}
