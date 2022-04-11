package com.restapi.bankapi.services;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.dto.response.AccountResponse;

import java.util.List;

public interface AccountService {


    AccountResponse create(AccountRequest accountRequest);

    List<AccountResponse> findAll();

    AccountResponse deposit(int accountNumber, int agency, double moneyAmount);

    AccountResponse withdraw(int accountNumber, int agency, double moneyAmount);

    void delete(int accountNumber, int agency);
}
