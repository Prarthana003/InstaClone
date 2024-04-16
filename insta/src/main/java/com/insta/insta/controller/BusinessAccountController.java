package com.insta.insta.controller;

import com.insta.insta.models.BusinessAccount;
import com.insta.insta.service.BusinessAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BusinessAccountController {

    private final BusinessAccountService businessAccountService;

    @Autowired
    public BusinessAccountController(BusinessAccountService businessAccountService) {
        this.businessAccountService = businessAccountService;
    }

    @GetMapping("/bus")
    public BusinessAccount getAccountDetails() {
        System.out.println("Fetching for..." + "1");
        //what to do later
        // userId = getInstance();
        //BusinessAccount = businessAccountService.findByUserId(UserId)
        BusinessAccount account = businessAccountService.findByUserId("2");
        BusinessAccount account1 = account;
        account.setUsername("someone");
        account1.display();
        return account;
    }

    @GetMapping("/list")
    public List<String> getList(){
        BusinessAccount account = businessAccountService.findByUserId("2");
        account.posts.dispay();
        return account.posts.getPostList();
    }


    @GetMapping("/pay/{userId}")
    public float getBill(@PathVariable("UserId") String UserId) {
        BusinessAccount account = businessAccountService.findByUserId(UserId);
        float bill = account.bill;
        return bill;
    }



    @PostMapping("/busAcc")
    public ResponseEntity<String> submitForm(@RequestBody BusinessAccount formData) {
        // Save the BusinessAccount object to the database (MongoDB or other)
        businessAccountService.saveBusinessAccount(formData);
        return ResponseEntity.ok("Form submitted successfully");
    }

    @PostMapping("/updateBill")
    public ResponseEntity<String> updateBill(@RequestParam("amt") float amt) {
        try {
            // Retrieve BusinessAccount by UserId "1"
            BusinessAccount businessAccount = businessAccountService.findByUserId("1");

            if (businessAccount != null) {
                // Get current bill amount
                float currentBill = businessAccount.getBill();
                // Calculate new bill amount after payment
                float newBill = Math.max(0, currentBill - amt);
                // Update bill amount
                businessAccount.setBill(newBill);

                // Save the updated BusinessAccount object
                businessAccountService.saveBusinessAccount(businessAccount);

                return ResponseEntity.ok("Bill updated successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating bill: " + e.getMessage());
        }
    }
}
