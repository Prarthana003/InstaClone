package com.insta.insta.controller;

import com.insta.insta.models.Account;
import com.insta.insta.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return "Account created successfully";
    }
}
