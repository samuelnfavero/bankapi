package com.restapi.bankapi.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(int accountNumber) {
        super(String.format("Account with number %s not found", accountNumber));
    }
}
