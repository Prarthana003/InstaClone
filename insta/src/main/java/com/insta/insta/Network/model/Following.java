package com.insta.insta.Network.model;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document("following")
public class Following {
    @Id
    private String id;

    @Field("userID")
    public String userID;

    public List<String> following;

    // Update the constructor to use parameters
    public Following(String userID, List<String> following) {
        this.userID = userID;
        this.following = following;
    }

    public void setFollowing(List<String> f) {
        following = f;
    }
}
