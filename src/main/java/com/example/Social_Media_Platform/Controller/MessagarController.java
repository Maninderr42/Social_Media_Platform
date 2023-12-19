package com.example.Social_Media_Platform.Controller;


import com.example.Social_Media_Platform.Models.Messager;
import com.example.Social_Media_Platform.RequestDTO.AddMessagerRequest;
import com.example.Social_Media_Platform.Service.MessagerService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("message")
public class MessagarController {


    @Autowired
    private MessagerService messagerService;


    @PostMapping("addmessage")
    public ResponseEntity addmeassage(@RequestBody AddMessagerRequest addMessagerRequest){

        try {
            String res=messagerService.addmessage(addMessagerRequest);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
@GetMapping("getMessageDetail")
    public Messager getMessageDetail(@RequestParam("messageId") Integer messageId) throws Exception{

        Messager messager=messagerService.getMessageDetail(messageId);
        return messager;

}


}
