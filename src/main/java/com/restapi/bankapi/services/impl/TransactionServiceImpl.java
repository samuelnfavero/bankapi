package com.restapi.bankapi.services.impl;

import com.restapi.bankapi.dto.request.TransactionRequest;
import com.restapi.bankapi.dto.response.TransactionResponse;
import com.restapi.bankapi.exceptions.AccountNotFoundException;
import com.restapi.bankapi.exceptions.InsufficientBalanceException;
import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.Transaction;
import com.restapi.bankapi.repository.AccountRepository;
import com.restapi.bankapi.repository.TransactionRepository;
import com.restapi.bankapi.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;


    @Override
    public TransactionResponse create(TransactionRequest transactionRequest) {
        Account providerAccount = getAccount(transactionRequest.getProviderAccountNumber());
        Account receiverAccount = getAccount(transactionRequest.getReceiverAccountNumber());
        checkIfProviderHasEnoughtMoney(transactionRequest, providerAccount);
        Transaction transaction = new Transaction(transactionRequest);

        providerAccount.setBankBalance(providerAccount.getBankBalance() - transaction.getMoneyAmount());
        receiverAccount.setBankBalance(receiverAccount.getBankBalance() + transaction.getMoneyAmount());

        transaction.setAccounts(List.of(providerAccount, receiverAccount));

        Transaction savedTransaction = transactionRepository.save(transaction);

        return new TransactionResponse(savedTransaction);
    }


    private Account getAccount(int accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }


    private void checkIfProviderHasEnoughtMoney(TransactionRequest transactionRequest, Account providerAccount) {

        if(transactionRequest.getMoneyAmount() > providerAccount.getBankBalance()){
            throw new InsufficientBalanceException();
        }
    }
}
