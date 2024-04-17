package com.insta.insta.controller;

import com.insta.insta.models.Account;
import com.insta.insta.models.BusinessAccount;
import com.insta.insta.models.PostList;
import com.insta.insta.models.Posts;
import com.insta.insta.service.AccountService;
import com.insta.insta.service.BusinessAccountService;
import com.insta.insta.service.PostListService;
import com.insta.insta.service.PostService;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private  BusinessAccountService busAccService;
    @Autowired
    private PostListService postListService;

    @Autowired
    private AccountService AccountService;

    @GetMapping("/list")
    public List<String> getPostList(){
        Account acc = AccountService.findByUserId("6");
        List<String> posts = acc.followersPostList;
        System.out.println("posts "+posts);
        return posts;
    }
    @GetMapping("/post")
    public byte[] getPostImage(@RequestParam String postId) {
        System.out.println("feching for "+postId);
        // Retrieve the image data by postId
        byte[] imageData = postService.findImageById(postId);
        return imageData;
    }

    @GetMapping("/followerList")
    public List<String> getFollowerList() {
        Account acc = AccountService.findByUserId("6");
        List<String> followers = acc.getFollowers();
        return followers;
    }

    @PostMapping("/create")
    public String createPost(@RequestParam(value = "image",required = false) MultipartFile image,
                             @RequestParam(value = "video", required = false)MultipartFile video) throws IOException {

        Posts newPost = new Posts();
        newPost.setPostId("1");

        if (image != null) {
            newPost.setImage(new Binary(image.getBytes()));
            newPost.setContentType("image");
        }

        if (video != null) {
            newPost.setVideo(new Binary(video.getBytes()));
            newPost.setContentType("video");
        }
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(currentDateTime);
//        newPost.setTimeStamp(timestamp);
//
//// Assign the timestamp to newPost
//        newPost.setTimeStamp(timestamp);
        newPost.userID = "2";

        BusinessAccount account = busAccService.findByUserId("2");
        if (account != null) {
//            PostList posts = account.getPosts();
            System.out.println("Finding for Id "+account.getUserId());
            PostList posts = postListService.findPostListById(account.id);
            System.out.println("found posts "+posts);
            if (posts == null) {
                posts = new PostList(); // Initialize the posts list if it's null
                posts.setId(account.UserId);
                account.setPosts(posts); // Set the initialized list back to account
            }
            posts.addPost(newPost.postId); // Now add the post to the list
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }


        postListService.addPostToPostList(newPost.postId);
        float temp  = account.bill;
        account.bill = temp +500;
        busAccService.saveBusinessAccount(account);
        postService.savePost(newPost);
        return "Post created successfully";
    }

    @PostMapping("/add")
    public String createPostPrivate(@RequestParam(value = "image",required = false) MultipartFile image,
                             @RequestParam(value = "video", required = false)MultipartFile video) throws IOException {

        Posts newPost = new Posts();
        newPost.setPostId("2");

        if (image != null) {
            newPost.setImage(new Binary(image.getBytes()));
            newPost.setContentType("image");
        }

        if (video != null) {
            newPost.setVideo(new Binary(video.getBytes()));
            newPost.setContentType("video");
        }
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(currentDateTime);
//        newPost.setTimeStamp(timestamp);
//
//// Assign the timestamp to newPost
//        newPost.setTimeStamp(timestamp);g `
        newPost.userID = "6";

        Account account = AccountService.findByUserId("6");
        if (account != null) {
//            PostList posts = account.getPosts();
            System.out.println("Finding for Id "+account.getUserId());
            PostList posts = postListService.findPostListById(account.id);
            System.out.println("found posts "+posts);
            if (posts == null) {
                posts = new PostList(); // Initialize the posts list if it's null
                posts.setId(account.UserId);
                account.setPosts(posts); // Set the initialized list back to account
            }
            posts.addPost(newPost.postId); // Now add the post to the list
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }


        postListService.addPostToPostList(newPost.postId);

        postListService.addPostToPostList(newPost.postId);

        for (String id : account.followers) {
            Account acc = AccountService.findByUserId(id);

            // Ensure followersPostList is initialized
            if (acc.getFollowersPostList() == null) {
                // Initialize followersPostList with an empty ArrayList
                acc.setFollowersPostList(new ArrayList<>());
            }

            // Add newPost.postId to followersPostList
            if (acc.getFollowersPostList() != null) { // Double-check for safety
                acc.getFollowersPostList().add(newPost.postId);
            }
            else{
                System.out.println("followers is null");
            }

            // Save the updated account
            AccountService.saveAccount(acc);
        }

        System.out.println("Added to followers' post lists");



        AccountService.saveAccount(account);
        postService.savePost(newPost);
        return "Post created successfully";
    }


}



