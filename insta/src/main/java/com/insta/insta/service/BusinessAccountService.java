package com.insta.insta.service;

import com.insta.insta.models.BusinessAccount;
import com.insta.insta.repositories.BusinessAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class BusinessAccountService {

    @Autowired
    private BusinessAccountRepository businessAccountRepository;

    public void saveBusinessAccount(BusinessAccount businessAccount) {
        businessAccountRepository.save(businessAccount);
    }




    public BusinessAccount findByUserId(String userId) {
        // Delegate the query to the repository method
        return businessAccountRepository.findByUserId(userId);
    }
}
