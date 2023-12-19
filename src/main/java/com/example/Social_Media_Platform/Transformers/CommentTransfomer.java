package com.example.Social_Media_Platform.Transformers;

import com.example.Social_Media_Platform.Models.Comments;
import com.example.Social_Media_Platform.RequestDTO.AddCommentRequest;

public class CommentTransfomer {

    public static Comments ConvertMessageEntity(AddCommentRequest addCommentRequest){

        Comments comments=Comments.builder()
                .commentId(addCommentRequest.getCommentId())
                .createdBy(addCommentRequest.getCreatedBy())
                .postsId(addCommentRequest.getPostsId())
                .textId(addCommentRequest.getTextId())
                .build();

        return comments;
    }
}
