package com.example.Social_Media_Platform.Transformers;

import com.example.Social_Media_Platform.Models.Admin;
import com.example.Social_Media_Platform.RequestDTO.AddAdminRequest;

public class AdminTransformer {

    public static Admin convertDataToModelAdminData(AddAdminRequest addAdminRequest){

        Admin admin= Admin.builder()
                .adminId(addAdminRequest.getAdminId())
                .userName(addAdminRequest.getUserName())
                .email(addAdminRequest.getEmail())
                .password(addAdminRequest.getPassword())
                .build();

        return admin;
    }
}
