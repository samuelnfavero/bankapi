package com.restapi.bankapi.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String cpf) {
        super(String.format("User with CPF = %s not found", cpf));
    }
}
