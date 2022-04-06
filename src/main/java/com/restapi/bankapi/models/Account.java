package com.restapi.bankapi.models;

import com.restapi.bankapi.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")
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
    @Enumerated(value = EnumType.STRING)
    private AccountTypeEnum type;
    @Column
    @CreatedDate
    private LocalDateTime creationDate;
    @Column
    @LastModifiedBy
    private LocalDateTime lastUpdate;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
