package com.example.Social_Media_Platform.Service;

import com.example.Social_Media_Platform.Enum.CheckStatus;
import com.example.Social_Media_Platform.Enum.Role;
import com.example.Social_Media_Platform.Exception.NotFoundException;
import com.example.Social_Media_Platform.Models.Admin;
import com.example.Social_Media_Platform.Models.User;
import com.example.Social_Media_Platform.RequestDTO.AddAdminRequest;
import com.example.Social_Media_Platform.Respository.AdminRespository;
import com.example.Social_Media_Platform.Respository.UserRespository;
import com.example.Social_Media_Platform.Transformers.AdminTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRespository adminRespository;

    @Autowired
    private UserRespository userRespository;


     // Adds a new admin to the database.

    public String add(AddAdminRequest addAdminRequest) {
        // Convert request data to admin model
        Admin admin = AdminTransformer.convertDataToModelAdminData(addAdminRequest);
        admin.setRole(Role.ADMIN);

        // Save admin data to the database
        adminRespository.save(admin);

        return "Admin SuccesFully Added in the DataBase.........";
    }


     // Deletes a user account and removes the user from all admin lists.
    public String deleteAcc(String userName ,Integer admiId) throws Exception {

        // Find the user in the database
        Optional<User> optional = userRespository.findUserByUsername(userName);

        // find admin in the database

        Optional<Admin> optionalAdmin=adminRespository.findById(admiId);

        //if given user not found return Exception message
        if (optional.isEmpty()) {
            throw new NotFoundException("User not Found in the Database.Please Check Username");
        }

        // if given admin not match in the database return Exception message
        if(optionalAdmin.isEmpty()){
            throw new NotFoundException("Admin not Found in the Database please chech Admin ID");
        }

        User user = optional.get();

        // Delete the user from the database
        userRespository.delete(user);

        // Find all admins from the database
        List<Admin> adminList = adminRespository.findAll();

        // remove the user from each admin's user list
        for (Admin admin : adminList) {
            admin.getUserList().remove(user);
            adminRespository.save(admin);
        }

        return "User Account delete SuccessFully from the DataBase......";
    }

    public List<User> viewAll(Integer adminId){

        List<User> userList=new ArrayList<>();

       // Find admins from the database
        Optional<Admin> optionalAdmin=adminRespository.findById(adminId);

        Admin admin=optionalAdmin.get();


        // remove the user from each admin's user list
        List<User> list=admin.getUserList();

        for(User user: list){
            userList.add(user);
        }

        return userList;


    }

    public String disableAccount(String userName, Integer adminId) throws Exception{

        // find user in the database
        Optional<User> optionalUser=userRespository.findUserByUsername(userName);

        // find admin in the database
        Optional<Admin> optionalAdmin=adminRespository.findById(adminId);


        //if given user not found return Exception message
        if(optionalUser.isEmpty()){
            throw  new NotFoundException("user not found in the Database.....");
        }

        // if given admin not match in the database return Exception message
        if(optionalAdmin.isEmpty()){
            throw new NotFoundException("Admin not Found in the Database please chech Admin ID");
        }

        User user=optionalUser.get();

        // user account disable
        user.setStatus(CheckStatus.DISABLE);

        userRespository.save(user);

        return userName+" is disable Sucessfully to DataBase....";
    }
}
