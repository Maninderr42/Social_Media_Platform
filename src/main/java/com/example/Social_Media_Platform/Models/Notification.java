package com.example.Social_Media_Platform.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Notification", collation = "{ 'locale': 'en' }")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    private Integer notificationId;

    private String content;

    private User user;



}
