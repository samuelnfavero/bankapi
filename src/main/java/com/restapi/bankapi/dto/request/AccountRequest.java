package com.restapi.bankapi.dto.request;

import com.restapi.bankapi.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@Getter
public class AccountRequest {

    private String userCpf;
    private int accountNumber;
    private int agency;
    private int bankBalance;
    @Enumerated(value = EnumType.STRING)
    private AccountTypeEnum type;
}
