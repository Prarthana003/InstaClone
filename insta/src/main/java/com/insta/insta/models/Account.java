package com.insta.insta.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Account")
public class Account {
    @Id
    public String id;
    public String userId;
    public String type;
    public String username;
    public String password;
    public String posts;

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
        return userId;
    }

    // Setter for userId
    public void setUserId(String userId) {
        this.userId = userId;
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

    // Getter for posts
    public String getPosts() {
        return posts;
    }

    // Setter for posts
    public void setPosts(String posts) {
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

    public void display() {
        System.out.println(this.userId + " " + this.username + " " + this.password + " " + this.posts + " " + this.type);
    }
}
