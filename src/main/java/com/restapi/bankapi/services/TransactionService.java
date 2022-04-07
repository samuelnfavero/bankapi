package com.restapi.bankapi.services;

import com.restapi.bankapi.dto.request.TransactionRequest;
import com.restapi.bankapi.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse create(TransactionRequest transactionRequest);
}
