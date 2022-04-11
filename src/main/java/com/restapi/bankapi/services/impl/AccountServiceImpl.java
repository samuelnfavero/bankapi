package com.restapi.bankapi.services.impl;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.dto.response.AccountResponse;
import com.restapi.bankapi.exceptions.AccountNotFoundException;
import com.restapi.bankapi.exceptions.InsufficientBalanceException;
import com.restapi.bankapi.exceptions.UserNotFoundException;
import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.User;
import com.restapi.bankapi.repository.AccountRepository;
import com.restapi.bankapi.repository.UserRepository;
import com.restapi.bankapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<AccountResponse> findAll() {
        return accountRepository.findAll(PageRequest.of(0,2)).stream()
                .map(AccountResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse deposit(int accountNumber, int agency, double moneyAmount) {

        Account account = getAccount(accountNumber, agency);
        account.setBankBalance(account.getBankBalance() + moneyAmount);
        account.setLastUpdate(LocalDateTime.now());
        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount);
    }

    @Override
    public AccountResponse withdraw(int accountNumber, int agency, double moneyAmount) {
        Account account = getAccount(accountNumber, agency);
        double balance = balanceValidation(account.getBankBalance(), moneyAmount);
        account.setBankBalance(balance);
        account.setLastUpdate(LocalDateTime.now());
        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount);
    }

    @Override
    public void delete(int accountNumber, int agency) {
        Account account = getAccount(accountNumber, agency);
        accountRepository.delete(account);
    }

    private double balanceValidation(double accountBalance, double moneyAmount){
        double balanceAfterWithdraw = accountBalance - moneyAmount;
        if(balanceAfterWithdraw < 0){
            throw new InsufficientBalanceException();
        }
        return  balanceAfterWithdraw;
    }

    private Account getAccount(int accountNumber, int agency){
        return accountRepository.findAccount(accountNumber, agency)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }

    private User getUser(String cpf){
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new UserNotFoundException(cpf));
    }
}
