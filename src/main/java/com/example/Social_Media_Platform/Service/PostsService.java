package com.example.Social_Media_Platform.Service;

import com.example.Social_Media_Platform.Enum.CheckStatus;
import com.example.Social_Media_Platform.Enum.PrivacySetting;
import com.example.Social_Media_Platform.Exception.NotFoundException;
import com.example.Social_Media_Platform.Exception.UserDisableException;
import com.example.Social_Media_Platform.Models.*;
import com.example.Social_Media_Platform.RequestDTO.AddPostsRequest;
import com.example.Social_Media_Platform.Respository.*;
import com.example.Social_Media_Platform.Transformers.PostsTransfomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private FollowingRespository followingRespository;

    @Autowired
    private FollowRespository followRespository;

    @Autowired
    private AnalyticRespository analyticRespository;

    @Autowired
    private UserRespository userRespository;

    public String addpost(AddPostsRequest addPostsRequest) throws Exception {

        // Convert DTO to entity
        Posts posts = PostsTransfomer.convertDataToModelPostsData(addPostsRequest);

        // Find the user by username
        Optional<User> optionalUser = userRespository.findUserByUsername(addPostsRequest.getCreatedUserName());

        // Check if the user exists
        if (optionalUser.isEmpty()) {
            throw new UserDisableException("User disabled by admin. Contact admin for more information.");
        }

        User user = optionalUser.get();

        // Create and save analytics data
        Analytic analytic = new Analytic();
        analytic.setAnalyicId(posts.getPostId());
        analytic.setUser(user);
        analytic.setAction("Add Posts");
        analyticRespository.save(analytic);

        posts.setLikes(0);
        posts.setDate(new Date());
        posts.setCommentOnPost(new ArrayList<>());
        posts.setUser(user);

        if (user.getPrivacysSettings() == PrivacySetting.PRIVACY) {
            // If user has privacy settings, share post with followers
            ArrayList<Follower> userFollowers = user.getFollower();

            for (Follower follower : userFollowers) {
                User followerUser = follower.getReciver();
                followerUser.getPublicPosts().add(posts);
                userRespository.save(followerUser);
            }
        } else {
            // If user has public posts, share post with followers and following users
            ArrayList<Follower> userFollowers = user.getFollower();

            for (Follower follower : userFollowers) {
                User followerUser = follower.getReciver();
                followerUser.getPublicPosts().add(posts);
                userRespository.save(followerUser);
                followRespository.save(follower);
            }

            ArrayList<Following> followingArrayList = user.getFollowings();
            for (Following following : followingArrayList) {
                User followingUser = following.getFollowingUser();
                followingUser.getPublicPosts().add(posts);
                userRespository.save(followingUser);
                followingRespository.save(following);
            }
        }

        // Save the post in the repository
        postsRepository.save(posts);

        return "Posts saved in the database successfully.";
    }




    public Posts getPostDetails(Integer postId) throws NotFoundException {
            Posts post = postsRepository.findById(postId)
                    .orElseThrow(() -> new NotFoundException("Post not found with id: " + postId));

            return  post;
        }




}
