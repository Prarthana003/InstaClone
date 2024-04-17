package com.insta.insta.service;

import com.insta.insta.models.Account;
import com.insta.insta.models.BusinessAccount;
import com.insta.insta.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public Account findByUserId(String UserId) {
        System.out.println("Fetching Account for UserId: " + UserId);
        return accountRepository.findByUserId(UserId);
    }
}
