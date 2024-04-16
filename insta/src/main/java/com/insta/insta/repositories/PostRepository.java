package com.insta.insta.repositories;

import com.insta.insta.models.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Posts, String> {

    // Method to find a Post by userId
    Posts findByPostId(String PostId);

}
