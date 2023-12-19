package com.example.Social_Media_Platform.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Analytic", collation = "{ 'locale': 'en' }")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Analytic {


    @Id
    private Integer analyicId;

    private String action;

    private User user;
}
