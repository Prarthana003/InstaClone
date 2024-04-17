package com.insta.insta.repositories;

import com.insta.insta.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    @Query("{ 'UserId' : ?0 }")
    Account findByUserId(String UserId);
}
