package com.insta.insta.service;

import com.insta.insta.models.PostList;
import com.insta.insta.repositories.PostListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostListService {

    private final PostListRepository postListRepository;

    @Autowired
    public PostListService(PostListRepository postListRepository) {
        this.postListRepository = postListRepository;
    }

    // Method to add a postId to a PostList
    public void addPostToPostList(String postId) {
        PostList postList = postListRepository.findByPostListContaining(postId);

        if (postList == null) {
            // If no PostList containing the postId exists, create a new PostList
            postList = new PostList();
        }

        // Add postId to the PostList
        postList.addPost(postId);

        // Save the updated PostList back to the repository
        postListRepository.save(postList);
    }

    // Method to find a PostList by postListId (document id)
    public PostList findPostListById(String postListId) {
        Optional<PostList> optionalPostList = postListRepository.findById(postListId);

        // Check if the PostList is present in the Optional
        if (optionalPostList.isPresent()) {
            return optionalPostList.get(); // Return the PostList if present
        } else {
            return null; // Return null if PostList is not found
        }
    }


    // Method to find a PostList by postId contained in the postList
    public PostList findPostListByPostId(String postId) {
        return postListRepository.findByPostListContaining(postId);
    }

    // Additional service methods can be added here for specific business logic

    // Example: Method to retrieve all PostLists
    public List<PostList> getAllPostLists() {
        return postListRepository.findAll();
    }
}
