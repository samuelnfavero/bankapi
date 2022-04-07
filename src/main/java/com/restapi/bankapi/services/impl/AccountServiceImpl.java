package com.restapi.bankapi.services.impl;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.dto.response.AccountResponse;
import com.restapi.bankapi.exceptions.UserNotFoundException;
import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.User;
import com.restapi.bankapi.repository.AccountRepository;
import com.restapi.bankapi.repository.UserRepository;
import com.restapi.bankapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AccountResponse create(AccountRequest accountRequest) {

        User user = getUser(accountRequest.getUserCpf());
        Account account = new Account(accountRequest);
        account.setId(user.getId());
        account.setUser(user);
        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount);
    }

    private User getUser(String cpf){
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new UserNotFoundException(cpf));
    }
}
