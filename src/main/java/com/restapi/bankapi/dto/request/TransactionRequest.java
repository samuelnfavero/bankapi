package com.restapi.bankapi.dto.request;

import com.restapi.bankapi.dto.response.TransactionResponse;
import com.restapi.bankapi.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionRequest {

    private int providerAccountNumber;

    private int providerAgency;

    private int receiverAccountNumber;

    private int receiverAgency;

    private double moneyAmount;


}
