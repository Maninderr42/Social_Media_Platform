package com.example.Social_Media_Platform.Transformers;

import com.example.Social_Media_Platform.Models.User;
import com.example.Social_Media_Platform.RequestDTO.AddUserRequest;

public class UserTransformer {

    public static User convertUserDataToModelData(AddUserRequest addUserRequest){

        User user=User.builder()
                .userId(addUserRequest.getId())
                .username(addUserRequest.getName())
                .bio(addUserRequest.getBio())
                .email(addUserRequest.getEmail())
                .profilPicture(addUserRequest.getProPic())
                .password(addUserRequest.getPassword())
                .build();

        return user;

    }
}
