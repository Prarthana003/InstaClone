package com.insta.insta.controller;

import com.insta.insta.models.Account;
import com.insta.insta.models.BusinessAccount;
import com.insta.insta.repositories.AccountRepository;
import com.insta.insta.repositories.BusinessAccountRepository;
import com.insta.insta.service.BusinessAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BusinessAccountController {

    @Autowired
    private BusinessAccountRepository accountRepository;

    @PostMapping("/busAcc")
    public ResponseEntity<String> submitForm(@RequestBody BusinessAccount formData) {

        // Save the Account object to the MongoDB collection
        BusinessAccount savedAccount = accountRepository.save(formData);

        // Display the saved Account details (optional)
//        formData.display();
//        savedAccount.display();

        BusinessAccount businessAccount = businessAccountService.findByUserId("1");
//        businessAccount.display();

        // Return a success response
        return ResponseEntity.ok("Form submitted successfully");


    }


    private final BusinessAccountService businessAccountService;

    @Autowired
    public BusinessAccountController(BusinessAccountService businessAccountService) {
        this.businessAccountService = businessAccountService;
    }

    @GetMapping("/businessAccount/{userId}")
    public BusinessAccount getBusinessAccountByUserId(@PathVariable("userId") String userId) {
        System.out.println("fetching data");
        return businessAccountService.findByUserId(userId);
    }
}
