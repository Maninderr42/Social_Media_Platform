package com.example.Social_Media_Platform.Controller;


import com.example.Social_Media_Platform.Models.Posts;
import com.example.Social_Media_Platform.RequestDTO.AddUserProfilUpdate;
import com.example.Social_Media_Platform.RequestDTO.AddUserRequest;
import com.example.Social_Media_Platform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // add new user to Database using post api
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody AddUserRequest addUserRequest){

      try {
          String res=userService.addUser(addUserRequest);
          return new ResponseEntity<>(res, HttpStatus.OK);

      }catch (Exception e){
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }


    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam("username") String usename , @RequestParam("username") String password){


        try {
            List<ArrayList<Posts>> res=userService.login(usename, password);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }




    }


    @PutMapping("/updateProfil")
    public ResponseEntity updataProfil(@RequestBody AddUserProfilUpdate addUserProfilUpdate){


        try {
            String res=userService.updateProfil(addUserProfilUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }






}
