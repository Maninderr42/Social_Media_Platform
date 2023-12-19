package com.example.Social_Media_Platform.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    private Integer Id;
    private String name;
    private String email;
    private String bio;
    private String proPic;
    private String password;
}
