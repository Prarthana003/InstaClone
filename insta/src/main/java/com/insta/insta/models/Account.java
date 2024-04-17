package com.insta.insta.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Account")
public class Account {
    @Id
    public String id;
    public String UserId;
    public String type;
    public String username;
    public String password;
    public PostList posts;
    public List<String> followers;
    public List<String> followersPostList;

    public List<String> getFollowers(){
        return this.followers;
    }


    public void setFollowers(){
        this.followers = new ArrayList<String>();
    }
    public  void setFollowersPostList(ArrayList<String> list){
        this.followers = list;
    }

    public void addFol(String id){
        this.followers.add(id);
    }
    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }

    // Getter for userId
    public String getUserId() {
        return UserId;
    }

    // Setter for userId
    public void setUserId(String userId) {
        this.UserId = userId;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
    public PostList getPosts() {
        PostList posts = new PostList();
        return posts;
    }

    public List<String> getFollowersPostList() {
        return followersPostList;
    }



    public void setPosts(PostList posts) {
        this.posts = posts;
    }


    // Other methods (Logout, displayLiked, displayCommented, chat, search, display)...

    public void Logout() {
        System.out.println("logout");
    }

    public void displayLiked() {
        System.out.println("liked");
    }

    public void displayCommented() {
        System.out.println("commented");
    }

    public void chat() {
        System.out.println("chat");
    }

    public void search() {
        System.out.println("Searching");
    }

    public void addPostToFollower(String id){
        this.followersPostList.add(id);
    }

    public void display() {
        System.out.println(this.UserId + " " + this.username + " " + this.password + " " + this.posts + " " + this.type);
    }
}
