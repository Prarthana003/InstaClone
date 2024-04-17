package com.insta.insta.Network.model;

import java.util.List;
import java.util.ArrayList;

public class Network_t {
    String id;
    public List<String> follower_list = new ArrayList<>();
    public List<String> following_list = new ArrayList<>();
    public List<String> requesters = new ArrayList<>();
    public List<String> requested = new ArrayList<>();
    public List<String> blocked = new ArrayList<>();

    public Network_t(List<String> followerList, List<String> followingList, List<String> requesters,
            List<String> requested) {
        this.follower_list = (followerList != null) ? followerList : new ArrayList<>();
        this.following_list = (followingList != null) ? followingList : new ArrayList<>();
        this.requesters = (requesters != null) ? requesters : new ArrayList<>();
        this.requested = (requested != null) ? requested : new ArrayList<>();
    }

    public void Follow(String to_id) {
        if (!requesters.contains(to_id)) {
            // If the element is not present, add it to the list
            requesters.add(to_id);
        }
        // Increase count of follow and following
    }

    public void addFollowing(String id) {
        if (!follower_list.contains(id)) {
            // If the element is not present, add it to the list
            following_list.add(id);
        }

    }

    public void Unfollow(String to_id) {
        if (!following_list.isEmpty()) {
            following_list.remove(to_id);
        } else {
            ;
        }

        // decrease count of follow and following
    }

    public void accept_request(String user_id) {
        requesters.remove(user_id);
        if (!follower_list.contains(user_id))
            follower_list.add(user_id);
    }

    public void Block(String user_id) {

        if (!blocked.contains(user_id))
            blocked.add(user_id);
        Unfollow(user_id);
    }

    public void add_follower(String user_id) {
        if (!follower_list.contains(user_id))
            follower_list.add(user_id);
    }

    public void remove_follower(String to_id) {
        if (!follower_list.isEmpty()) {
            follower_list.remove(to_id);
        } else {
            ;
        }
    }

    public List<String> display_followers() {
        return follower_list;
    }

    public List<String> display_requests() {
        return requesters;
    }

    public List<String> display_following() {
        return following_list;
    }

}
