package com.restapi.bankapi.controllers;

import com.restapi.bankapi.dto.request.TransactionRequest;
import com.restapi.bankapi.dto.response.TransactionResponse;
import com.restapi.bankapi.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public TransactionResponse create(@RequestBody @Valid TransactionRequest transactionRequest){
        return transactionService.create(transactionRequest);
    }
}
