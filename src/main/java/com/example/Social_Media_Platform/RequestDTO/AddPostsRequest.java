package com.example.Social_Media_Platform.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPostsRequest {

    private Integer postId;
    private String createdUserName;
    private String content;
    private String description;
    private String title;
}
