package com.example.Social_Media_Platform.Service;


import com.example.Social_Media_Platform.Exception.NotFoundException;
import com.example.Social_Media_Platform.Models.Comments;
import com.example.Social_Media_Platform.Models.Posts;
import com.example.Social_Media_Platform.Models.User;
import com.example.Social_Media_Platform.RequestDTO.AddCommentRequest;
import com.example.Social_Media_Platform.Respository.CommentRespository;
import com.example.Social_Media_Platform.Respository.PostsRepository;
import com.example.Social_Media_Platform.Transformers.CommentTransfomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRespository commentRespository;

    @Autowired
    private PostsRepository postsRepository;

    public AddCommentRequest createComment(AddCommentRequest addCommentRequest) throws Exception{

        Comments comments= CommentTransfomer.ConvertMessageEntity(addCommentRequest);

        Optional<Posts> postsOptional=postsRepository.findById(addCommentRequest.getPostsId());

        if(postsOptional.isEmpty()){
            throw new NotFoundException("posts not found");
        }

        Posts posts=postsOptional.get();

        User user=posts.getUser();

        posts.getCommentOnPost().add(comments);

        postsRepository.save(posts);

        commentRespository.save(comments);

        return addCommentRequest;



    }
}
