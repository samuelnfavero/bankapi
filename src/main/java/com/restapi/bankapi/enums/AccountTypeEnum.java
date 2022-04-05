package com.restapi.bankapi.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountTypeEnum {
    CORRENTE("Conta-corrente"),
    POUPANCA("Conta de poupança"),
    SALARIO("Conta-salário");

    private final String accountType;
}
