package com.insta.insta.controller;

import com.insta.insta.models.Account;
import com.insta.insta.models.Posts;
import com.insta.insta.service.AccountService;
import com.insta.insta.service.BusinessAccountService;
import com.insta.insta.service.PostListService;
import com.insta.insta.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class FeedController {
    @RestController
    @RequestMapping("/api/feed")
    public class PostController {

        @Autowired
        private PostService postService;
        @Autowired
        private BusinessAccountService busAccService;
        @Autowired
        private PostListService postListService;

        @Autowired
        private com.insta.insta.service.AccountService AccountService;

        @GetMapping("/post")
        public byte[] getPost(@RequestParam String postId) {
            // Retrieve the image data by postId
            byte[] imageData = postService.findImageById(postId);
            return imageData;
        }







    }

}
