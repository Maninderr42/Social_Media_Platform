package com.example.Social_Media_Platform.Models;



import com.example.Social_Media_Platform.Enum.CheckStatus;
import com.example.Social_Media_Platform.Enum.PrivacySetting;
import com.example.Social_Media_Platform.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Data
@Document (collection = "user", collation = "{ 'locale': 'en' }")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    private Integer userId;

    private String username;

    private String email;

    private String bio;

    private String profilPicture;

    private Boolean verfication;

    private Integer noOfPosts;

    private String password;

    private Integer noOfFriendReq;

    @Field("CheckStatus")
    private CheckStatus Status;

    @Field("Role")
    private Role role;


    private Admin admin;

    @Field("PrivacySetting")
    private PrivacySetting privacysSettings;

    @DBRef
    private ArrayList<Posts> posts=new ArrayList<>();

    @DBRef
    private ArrayList<Messager> messages=new ArrayList<>();

    @DBRef
    private ArrayList<Follower> follower=new ArrayList<>();

    @DBRef
    private ArrayList<Following> followings=new ArrayList<>();

    @DBRef
    public ArrayList<Posts> publicPosts=new ArrayList<>();

    @DBRef
    public ArrayList<Notification> notifications=new ArrayList<>();

    @DBRef
    private ArrayList<FriendRequest> senderFreindRequest=new ArrayList<>();

    @DBRef
    private ArrayList<FriendRequest> reciverFriendRequest=new ArrayList<>();

}
