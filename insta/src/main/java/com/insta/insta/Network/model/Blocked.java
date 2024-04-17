package com.insta.insta.Network.model;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document("blocked")
public class Blocked {
    @Id
    private String id;
    public String userID;
    public List<String> blocked = new ArrayList<>();

    public Blocked(String userID, List<String> blocked) {
        this.blocked = blocked;
        this.userID = userID;
    }

    public boolean block(String id) {
        for (String x : blocked) {
            if (x.equals(id))
                return false;
        }
        blocked.add(id);
        return true;
    }

    public boolean unblock_user(String id) {
        for (String x : blocked) {
            if (x.equals(id)) {
                blocked.remove(id);
                return true;
            }

        }
        return false;

    }

}
