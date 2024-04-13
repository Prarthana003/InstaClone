package com.insta.insta.repositories;

import com.insta.insta.models.BusinessAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAccountRepository extends MongoRepository<BusinessAccount, String> {

    // Method to find a BusinessAccount by userId using custom query
    @Query("{ 'UserId' : ?0 }")
    BusinessAccount findByUserId(String UserId);

}
