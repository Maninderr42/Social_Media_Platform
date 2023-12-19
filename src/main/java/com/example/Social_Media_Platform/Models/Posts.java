package com.example.Social_Media_Platform.Models;

import com.example.Social_Media_Platform.Enum.PrivacySetting;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "posts", collation = "{ 'locale': 'en' }")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    @Id
    private Integer postId;
    private String createdUserName;
    private String url;
    private String description;
    private String title;
    private Integer likes;
    private User user;

    @Field("created_at")
    @CreatedDate
    private Date Date;

    @PrePersist
    protected void onCreate() {
        Date = new Date();
    }

    @DBRef
    ArrayList<Comments> commentOnPost=new ArrayList<>();
}
