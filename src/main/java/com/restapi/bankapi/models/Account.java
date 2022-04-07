package com.restapi.bankapi.models;

import com.restapi.bankapi.dto.request.AccountRequest;
import com.restapi.bankapi.enums.AccountTypeEnum;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private int accountNumber;
    @Column
    private int agency;
    @Column
    private double bankBalance;
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

    public Account(AccountRequest accountRequest){
        accountNumber = accountRequest.getAccountNumber();
        agency = accountRequest.getAgency();
        bankBalance = accountRequest.getBankBalance();
        type = accountRequest.getType();
    }
}
