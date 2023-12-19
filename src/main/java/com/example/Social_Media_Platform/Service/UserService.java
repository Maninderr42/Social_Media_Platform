package com.example.Social_Media_Platform.Service;


import com.example.Social_Media_Platform.Enum.CheckStatus;
import com.example.Social_Media_Platform.Enum.PrivacySetting;
import com.example.Social_Media_Platform.Enum.Role;
import com.example.Social_Media_Platform.Exception.*;
import com.example.Social_Media_Platform.Models.Admin;
import com.example.Social_Media_Platform.Models.Analytic;
import com.example.Social_Media_Platform.Models.Posts;
import com.example.Social_Media_Platform.Models.User;
import com.example.Social_Media_Platform.RequestDTO.AddUserProfilUpdate;
import com.example.Social_Media_Platform.RequestDTO.AddUserRequest;
import com.example.Social_Media_Platform.Respository.AdminRespository;
import com.example.Social_Media_Platform.Respository.AnalyticRespository;
import com.example.Social_Media_Platform.Respository.PostsRepository;
import com.example.Social_Media_Platform.Respository.UserRespository;
import com.example.Social_Media_Platform.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private AdminRespository adminRespository;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private AnalyticRespository analyticRespository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(AddUserRequest addUserRequest) throws Exception{

        User user= UserTransformer.convertUserDataToModelData(addUserRequest);

        //check name is present or not
        Optional<User> userOptional=userRespository.findUserByUsername(addUserRequest.getName());

        // if name is already present in the database return Exception
        if(userOptional.isPresent()){
              throw new AlreadyNameFoundException("Name Already Present in the DataBase Please use different name");
        }

        //check email is present or not
        Optional<User> optionalUser2=userRespository.findEmailByEmail(addUserRequest.getEmail());

        // if email found in database return Exception
        if(optionalUser2.isPresent()){
            throw new AlreadyEmailFoundException("Email Already Present in the DataBase Please use different Email");
        }

        //if name and email not found in database then stored new user in database

        user.setStatus(CheckStatus.ACTIVE);
       user.setPassword(passwordEncoder.encode(addUserRequest.getPassword()));
        user.setPrivacysSettings(PrivacySetting.PUBLIC);
        user.setNoOfFriendReq(0);
        user.setNoOfPosts(0);
        user.setVerfication(false);
        user.setFollowings(new ArrayList<>());
        user.setFollower(new ArrayList<>());
        user.setMessages(new ArrayList<>());
        user.setPosts(new ArrayList<>());
        user.setNotifications(new ArrayList<>());
        user.setPublicPosts(new ArrayList<>());
        user.setSenderFreindRequest(new ArrayList<>());
        user.setReciverFriendRequest(new ArrayList<>());




        // find all admins from the database
        List<Admin> arrayList=adminRespository.findAll();

        // Add the user to each admin list
        for(Admin admin: arrayList){

            admin.getUserList().add(user);
            adminRespository.save(admin);

        }



        // save user to database
        userRespository.save(user);

        return "Add user to DataBase SuccessFully..........";


    }

    public List<ArrayList<Posts>> login(String usename, String password) throws Exception{


        // find user by username in Database
        Optional<User> userOptional=userRespository.findUserByUsername(usename);

        // if username not present in the Database return Exception message
        if(!userOptional.isPresent()){
            throw new UserNameAndPasswordInCorrectException(" UserName and Password Are Incorrect Please Check UserName and Password");

        }

        // if  user find in database then collection all user infomation
        User user=userOptional.get();

        // if password not equals to user database then return Exception message
        if(user.getPassword().equals(password)){
            throw new UserNameAndPasswordInCorrectException(" UserName and Password Are Incorrect Please Check UserName and Password");

        }

        // if admin disable user account then return mesaage
        if(user.getVerfication().equals(CheckStatus.DISABLE)){
            throw new UserDisableException(usename+" is Disable  By Admin Contact Admin Team ...");
        }

        List<ArrayList<Posts>> postsList=new ArrayList<>();

        // Collect all public post and return to user
        List<User> list=userRespository.findAll();

        for(User user1:list){
            postsList.add(user1.getPublicPosts());
        }

        return postsList;


    }

    public String updateProfil(AddUserProfilUpdate addUserProfilUpdate) throws Exception{

        Optional<User> optionalUser=userRespository.findUserByUsername(addUserProfilUpdate.getUserName());

        if(optionalUser.isEmpty()){
            throw new NotFoundException("User not Found in the Database Please Check username");
        }


        User user=optionalUser.get();

        if (user.getStatus()==CheckStatus.DISABLE){
            throw new UserDisableException("You can't Update profil");
        }

        user.setPassword(addUserProfilUpdate.getPassword());
        user.setProfilPicture(addUserProfilUpdate.getProPic());
        user.setBio(addUserProfilUpdate.getBio());

        Analytic analytic=new Analytic();
        analytic.setAnalyicId(user.getUserId());
        analytic.setUser(user);
        analytic.setAction("Update Profil");

        analyticRespository.save(analytic);



        userRespository.save(user);

        return "User Update Profil SuccessFully......";




    }
}
