package com.example.Social_Media_Platform.Models;


import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "Messager", collation = "{ 'locale': 'en' }")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Messager {

    @Id
    private Integer messagerId;
    private String sendUserName;
    private String reciverUserName;
    private String text;
    @Field("created_at")
    @CreatedDate
    private Date Date;

    @PrePersist
    protected void onCreate() {
        Date = new Date();
    }
    private User user;




}
