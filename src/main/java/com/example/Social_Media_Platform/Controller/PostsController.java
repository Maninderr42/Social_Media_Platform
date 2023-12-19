package com.example.Social_Media_Platform.Controller;

import com.example.Social_Media_Platform.Models.Posts;
import com.example.Social_Media_Platform.RequestDTO.AddPostsRequest;
import com.example.Social_Media_Platform.Service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @PostMapping("addPost")
    public ResponseEntity<String> addPost(@RequestBody AddPostsRequest addPostsRequest) {
        try {
            String res = postsService.addpost(addPostsRequest);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getPostDetail")
    public ResponseEntity<Posts> getPostDetail(@RequestParam("postId") Integer postId) {
        try {
            Posts post = postsService.getPostDetails(postId);
            return ResponseEntity.ok(post);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
