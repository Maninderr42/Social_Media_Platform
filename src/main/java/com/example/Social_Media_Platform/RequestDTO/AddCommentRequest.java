package com.example.Social_Media_Platform.RequestDTO;


import com.example.Social_Media_Platform.Models.Posts;
import com.example.Social_Media_Platform.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddCommentRequest {
    private Integer commentId;
    private User createdBy;
    private String textId;
    private Integer postsId;}
