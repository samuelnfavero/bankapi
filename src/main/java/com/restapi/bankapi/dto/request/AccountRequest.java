package com.restapi.bankapi.dto.request;

import com.restapi.bankapi.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class AccountRequest {

    @NotNull
    private String userCpf;
    @NotNull
    private int accountNumber;
    @NotNull
    private int agency;
    @NotNull
    private double bankBalance;
    @Enumerated(value = EnumType.STRING)
    private AccountTypeEnum type;
}
