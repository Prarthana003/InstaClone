
//package com.insta.Instagram_clone.Network.model;
package com.example.instagram_clone.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document("followers")
public class Follower {
    @Id
    private String id;
    public String userID; // Change field name to userId
    public List<String> followers;

    public Follower(String userID, List<String> followers) {
        this.userID = userID;
        this.followers = followers;
    }

    public void setFollower(List<String> f) {
        followers = f;
    }
}
