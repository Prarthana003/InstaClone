package com.insta.insta.repositories;


import com.insta.insta.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface AccountRepository extends MongoRepository<Account, String> {
}
