package com.restapi.bankapi.models;

import com.restapi.bankapi.dto.request.TransactionRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document(collection = "transaction")
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Transaction {




    private int providerAccountNumber;

    private int providerAgency;

    private int receiverAccountNumber;

    private int receiverAgency;

    private double moneyAmount;

    @CreatedDate
    private LocalDateTime transactionDate;

    private List<Account> accounts;

    public Transaction(TransactionRequest transactionRequest){
        providerAccountNumber = transactionRequest.getProviderAccountNumber();
        providerAgency = transactionRequest.getProviderAgency();
        receiverAccountNumber = transactionRequest.getReceiverAccountNumber();
        receiverAgency = transactionRequest.getReceiverAgency();
        moneyAmount = transactionRequest.getMoneyAmount();
    }
}
