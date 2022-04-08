package com.restapi.bankapi.dto.request;

import com.restapi.bankapi.dto.response.TransactionResponse;
import com.restapi.bankapi.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class TransactionRequest {

    @NotNull
    private int providerAccountNumber;
    @NotNull
    private int providerAgency;
    @NotNull
    private int receiverAccountNumber;
    @NotNull
    private int receiverAgency;
    @NotNull
    private double moneyAmount;
}