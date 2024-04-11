package com.insta.insta.controller;

import com.insta.insta.models.Account;
import com.insta.insta.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FormController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/submit-form")
    public ResponseEntity<String> submitForm(@RequestBody Account formData) {

        // Save the Account object to the MongoDB collection
        Account savedAccount = accountRepository.save(formData);

        // Display the saved Account details (optional)
        formData.display();
        savedAccount.display();

        // Return a success response
        return ResponseEntity.ok("Form submitted successfully");
    }
}
