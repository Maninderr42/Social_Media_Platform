package com.example.Social_Media_Platform.Controller;


import com.example.Social_Media_Platform.RequestDTO.AddCommentRequest;
import com.example.Social_Media_Platform.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")

public class CommentController {

    @Autowired
    private CommentService commentService;

    @PutMapping("commentPost")
    public ResponseEntity createComment(@RequestBody AddCommentRequest addCommentRequest){
        try{
            AddCommentRequest addCommentRequest1 = commentService.createComment(addCommentRequest);
            return new ResponseEntity<>(addCommentRequest1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
