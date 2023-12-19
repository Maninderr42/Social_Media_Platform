package com.example.Social_Media_Platform.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "comments", collation = "{ 'locale': 'en' }")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Comments{

    @Id
    private Integer commentId;
    private User createdBy;
    private String textId;
    private Integer postsId;
    private Posts posts;


}
