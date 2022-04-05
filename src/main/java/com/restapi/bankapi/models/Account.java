package com.restapi.bankapi.models;

import com.restapi.bankapi.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private int accountNumber;
    @Column
    private int agency;
    @Column
    private int bankBalance;
    @Column
    private AccountTypeEnum type;
    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime lastUpdateDate;
    @ManyToOne
    private User user;
}
