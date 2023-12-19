package com.example.Social_Media_Platform.Models;



import com.example.Social_Media_Platform.Enum.CheckStatus;
import com.example.Social_Media_Platform.Enum.Role;
import jakarta.annotation.Generated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;


@Data
@Document (collection = "admin", collation = "{ 'locale': 'en' }")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {


    @Id
    private Integer adminId;
    private String userName;
    private String email;
    @Field("Role")
    private Role role;
    private String password;

    @DBRef
    ArrayList<User> userList=new ArrayList<>();



}
