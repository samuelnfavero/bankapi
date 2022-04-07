package com.restapi.bankapi.exceptions;

import com.restapi.bankapi.dto.request.TransactionRequest;
import com.restapi.bankapi.models.Account;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("Insufficient balance of tha provider");
    }
}
