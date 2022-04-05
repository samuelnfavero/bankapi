package com.restapi.bankapi.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private String birthDate;
    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime lastUpdateDate;
    @OneToMany
    private List<Account> accounts;
}
