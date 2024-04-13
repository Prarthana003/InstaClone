package com.insta.insta.service;

import com.insta.insta.models.BusinessAccount;
import com.insta.insta.repositories.BusinessAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessAccountService {

    private final BusinessAccountRepository businessAccountRepository;

    @Autowired
    public BusinessAccountService(BusinessAccountRepository businessAccountRepository) {
        this.businessAccountRepository = businessAccountRepository;
    }

    // Method to save or update a BusinessAccount
    public void saveBusinessAccount(BusinessAccount businessAccount) {
        businessAccountRepository.save(businessAccount);
    }

    // Method to find a BusinessAccount by userId
    public BusinessAccount findByUserId(String UserId) {
        System.out.println("Fetching....."+UserId);
        return businessAccountRepository.findByUserId(UserId);
    }

    // Additional service methods can be added here for specific business logic

}
