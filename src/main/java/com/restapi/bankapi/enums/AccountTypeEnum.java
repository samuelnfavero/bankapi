package com.restapi.bankapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountTypeEnum {
    CORRENTE("Conta-corrente"),
    POUPANCA("Conta de poupança"),
    SALARIO("Conta-salário");

    private final String accountType;
}
