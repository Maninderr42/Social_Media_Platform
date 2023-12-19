package com.example.Social_Media_Platform.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserProfilUpdate {

    private  String userName;

    private String bio;

    private String proPic;

    private String password;

}
