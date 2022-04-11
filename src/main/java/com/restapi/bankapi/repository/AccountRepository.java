package com.restapi.bankapi.repository;

import com.restapi.bankapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("select a from Account a where (a.accountNumber =?1 and a.agency=?2)")
    Optional<Account> findAccount(int accountNumber, int agency);


}
