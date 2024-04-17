package com.insta.insta.Network.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document("requests")
public class Requests {
    @Id
    private String id;
    public String userID; // Change field name to userId
    public List<String> requesters;

    public Requests(String userID, List<String> requesters) {
        this.userID = userID;
        this.requesters = requesters;
    }

    public void setFollower(List<String> f) {
        requesters = f;
    }

}
