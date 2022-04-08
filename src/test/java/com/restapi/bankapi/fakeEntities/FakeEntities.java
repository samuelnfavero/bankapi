package com.restapi.bankapi.fakeEntities;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.enums.AccountTypeEnum;
import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.User;

public class FakeEntities {

    public static Account createFakeAccount(){
        AccountRequest accountRequest = new AccountRequest(
                "98308588042",
                4870,
                81390,
                800,
                AccountTypeEnum.CORRENTE);
        return new Account(accountRequest);
    }


    public static User createFakeUser(){
        UserRequest userRequest = new UserRequest("Samuel", "98308588042", "01/07/1996");
        return new User(userRequest);
    }
}
