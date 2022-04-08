package com.restapi.bankapi.repository;

import com.restapi.bankapi.fakeEntities.FakeEntities;
import com.restapi.bankapi.models.Account;
import com.restapi.bankapi.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void shouldFindAnAccountWhenReceiveAgencyAndAccountNumber(){
        User fakeUser = FakeEntities.createFakeUser();
        Account fakeAccount = FakeEntities.createFakeAccount();

        entityManager.persist(fakeUser);
        entityManager.persist(fakeAccount);

        Account account = accountRepository.findAccount(fakeAccount.getAccountNumber(), fakeAccount.getAgency()).get();

        Assertions.assertEquals(fakeAccount.getAccountNumber(), account.getAccountNumber());
        Assertions.assertEquals(fakeAccount.getAgency(), account.getAgency());
        Assertions.assertEquals(fakeAccount.getBankBalance(), account.getBankBalance());
        Assertions.assertEquals(fakeAccount.getType(), account.getType());

    }
}
