package com.insta.insta.repositories;

import com.insta.insta.models.BusinessAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAccountRepository extends MongoRepository<BusinessAccount, String> {

    // Define a query method to find a BusinessAccount by userId
    BusinessAccount findByUserId(String userId);

}
