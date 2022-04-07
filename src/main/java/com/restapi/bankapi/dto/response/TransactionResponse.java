package com.restapi.bankapi.dto.response;

import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class TransactionResponse {

    private LocalDateTime transactionDate;

    private List<Account> accounts;

    public TransactionResponse(Transaction transaction){
        transactionDate = transaction.getTransactionDate();
        accounts = transaction.getAccounts();
    }
}
