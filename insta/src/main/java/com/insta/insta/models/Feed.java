package com.insta.insta.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("feed")
public class Feed {
    @Id
    public String id;
    public PostList list;

    public void addPost(String postId){
        System.out.println("added post");

    }

    public void removePost(String postId){
        System.out.println("post removed");
    }

    public void playPost(String postId){
        System.out.println("playing the post");
    }

}
