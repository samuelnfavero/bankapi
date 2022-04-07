package com.restapi.bankapi.dto.response;

import com.restapi.bankapi.enums.AccountTypeEnum;
import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AccountResponse {

    private int accountNumber;
    private int agency;
    private double bankBalance;
    @Enumerated(value = EnumType.STRING)
    private AccountTypeEnum type;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private User user;

    public AccountResponse(Account account){
        accountNumber = account.getAccountNumber();
        agency = account.getAgency();
        bankBalance = account.getBankBalance();
        type = account.getType();
        creationDate = account.getCreationDate();
        lastUpdate = account.getLastUpdate();
        user = account.getUser();
    }
}
