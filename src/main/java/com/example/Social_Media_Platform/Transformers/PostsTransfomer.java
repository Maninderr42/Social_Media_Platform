package com.example.Social_Media_Platform.Transformers;

import com.example.Social_Media_Platform.Models.Posts;
import com.example.Social_Media_Platform.RequestDTO.AddPostsRequest;

public class PostsTransfomer {

    public static Posts convertDataToModelPostsData(AddPostsRequest addPostsRequest){

        Posts posts= Posts.builder()
                .postId(addPostsRequest.getPostId())
                .title(addPostsRequest.getTitle())
                .postId(addPostsRequest.getPostId())
                .url(addPostsRequest.getContent())
                .description(addPostsRequest.getDescription())
                .createdUserName(addPostsRequest.getCreatedUserName())
                .build();

        return posts;
    }
}
