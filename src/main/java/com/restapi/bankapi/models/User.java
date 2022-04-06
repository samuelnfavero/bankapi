package com.restapi.bankapi.models;

import com.restapi.bankapi.dto.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    public User(UserRequest userRequest){
        name = userRequest.getName();
        cpf = userRequest.getCpf();
        birthDate = userRequest.getBirthDate();
    }
}
