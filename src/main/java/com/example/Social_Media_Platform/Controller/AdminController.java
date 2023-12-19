package com.example.Social_Media_Platform.Controller;


import com.example.Social_Media_Platform.Models.Admin;
import com.example.Social_Media_Platform.Models.User;
import com.example.Social_Media_Platform.RequestDTO.AddAdminRequest;
import com.example.Social_Media_Platform.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // add new admin to DataBase using post Api
    @PostMapping("/addAdmin")
    public ResponseEntity addAdmin(@RequestBody AddAdminRequest addAdminRequest) {
        String res=adminService.add(addAdminRequest);
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @GetMapping("deleteAccount")
    public ResponseEntity deleteAcc(@RequestParam String userName, @RequestParam Integer adminId){
        try {

            String res=adminService.deleteAcc(userName, adminId);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("viewAllAccount")
    public List<User> viewAll(@RequestParam Integer adminId){
        List<User> list=adminService.viewAll(adminId);
        return list;
    }

    @PutMapping("disableAccount")
    public ResponseEntity disableAccount(@RequestParam String userName, @RequestParam Integer adminId){
        try {

            String res=adminService.disableAccount(userName, adminId);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
