package com.insta.insta.controller;

import com.insta.insta.models.Account;
import com.insta.insta.models.BusinessAccount;
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
        account.setFollowers();
        account.addFol("3");
        account.addFol("4");
        account.addFol("5");
        accountService.saveAccount(account);
        return "Account created successfully";
    }

    @GetMapping("/pers")
    public Account getAccountDetails() {
        System.out.println("Fetching for..." + "3");
        //what to do later
        // userId = getInstance();
        //BusinessAccount = businessAccountService.findByUserId(UserId)
        Account account = accountService.findByUserId("6");
        Account account1 = account;
        System.out.println("followers "+account1.followers);
        account1.display();
        return account;
    }



}
