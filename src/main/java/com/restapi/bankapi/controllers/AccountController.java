package com.restapi.bankapi.controllers;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.dto.response.AccountResponse;
import com.restapi.bankapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public AccountResponse create(@RequestBody @Valid AccountRequest accountRequest){
        return accountService.create(accountRequest);
    }
}
