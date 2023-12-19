package com.example.Social_Media_Platform.RequestDTO;

import com.example.Social_Media_Platform.Models.Admin;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddAdminRequest {

    private Integer adminId;
    private String userName;
    private String email;
    private String password;


}
