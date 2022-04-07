package com.restapi.bankapi.models;

import com.restapi.bankapi.dto.request.TransactionRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    //Aqui eu vou fazer a busca personalizada por conta e agencia

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private int providerAccountNumber;

    @Column
    private int providerAgency;

    @Column
    private int receiverAccountNumber;

    @Column
    private int receiverAgency;

    @Column
    private double moneyAmount;

    @Column
    @CreatedDate
    private LocalDateTime transactionDate;

    @OneToMany //Aqui é ManyToMany
    private List<Account> accounts;

    public Transaction(TransactionRequest transactionRequest){
        providerAccountNumber = transactionRequest.getProviderAccountNumber();
        providerAgency = transactionRequest.getProviderAgency();
        receiverAccountNumber = transactionRequest.getReceiverAccountNumber();
        receiverAgency = transactionRequest.getReceiverAgency();
        moneyAmount = transactionRequest.getMoneyAmount();
    }
}
