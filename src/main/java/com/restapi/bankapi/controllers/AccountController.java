package com.restapi.bankapi.controllers;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.dto.response.AccountResponse;
import com.restapi.bankapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public AccountResponse create(@RequestBody @Valid AccountRequest accountRequest){
        return accountService.create(accountRequest);
    }

    @GetMapping
    public List<AccountResponse> findAll(){
        return accountService.findAll();
    }

    @PutMapping("/deposit")
    public AccountResponse deposit(@RequestParam int accountNumber,
                                   @RequestParam int agency,
                                   @RequestParam double moneyAmount){
        return accountService.deposit(accountNumber, agency, moneyAmount);
    }

    @PutMapping("/withdraw")
    public AccountResponse withdraw(@RequestParam int accountNumber,
                                    @RequestParam int agency,
                                    @RequestParam double moneyAmount){
        return accountService.withdraw(accountNumber, agency, moneyAmount);
    }

    @DeleteMapping
    public String delete(@RequestParam int accountNumber, @RequestParam int agency){
        accountService.delete(accountNumber, agency);
        return "ACCOUNT DELETED!";
    }
}
