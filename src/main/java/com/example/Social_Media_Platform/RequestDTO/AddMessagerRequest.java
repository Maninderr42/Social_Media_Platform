package com.example.Social_Media_Platform.RequestDTO;


import com.example.Social_Media_Platform.Models.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMessagerRequest {

    private Integer messagerId;
    private String sendUserName;
    private Posts postId;
    private String reciverUserName;
    private String text;
}
