package com.restapi.bankapi.dto.response;

import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserResponse {
    private String name;
    private String cpf;
    private String birthDate;
    private List<Account> accounts;

    public UserResponse(User user){
        name = user.getName();
        cpf = user.getCpf();
        birthDate = user.getBirthDate();
        accounts = user.getAccounts();
    }
}
