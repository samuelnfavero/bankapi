package com.restapi.bankapi.services;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.dto.response.AccountResponse;

public interface AccountService {


    AccountResponse create(AccountRequest accountRequest);
}
