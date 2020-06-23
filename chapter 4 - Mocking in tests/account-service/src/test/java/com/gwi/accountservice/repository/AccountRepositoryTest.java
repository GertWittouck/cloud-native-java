package com.gwi.accountservice.repository;

import com.gwi.accountservice.model.Account;
import com.gwi.accountservice.model.AccountNumber;
import com.sun.accessibility.internal.resources.accessibility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    private static final AccountNumber ACCOUNT_NUMBER = new AccountNumber("098765432");

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findUserAccountsShouldReturnAccounts() {
        String username = "jack";
        entityManager.persist(new Account(username, ACCOUNT_NUMBER));

        List<Account> accounts = accountRepository.findByUsername(username);

        assertThat(accounts).size().isEqualTo(1);
        assertThat(accounts.get(0).getAccountNumber()).isEqualTo(ACCOUNT_NUMBER);
        assertThat(accounts.get(0).getUsername()).isEqualTo(username);
    }

    @Test
    public void findAccountShouldReturnAccount() {
        entityManager.persist(new Account("jill", ACCOUNT_NUMBER));

        Account account = accountRepository.findAccountByAccountNumber(ACCOUNT_NUMBER);

        assertThat(account).isNotNull();
        assertThat(account.getAccountNumber()).isEqualTo(ACCOUNT_NUMBER);
    }

    @Test
    public void findAccountShouldReturnNull() {
        entityManager.persist(new Account("jack", ACCOUNT_NUMBER));

        Account account = accountRepository.findAccountByAccountNumber(new AccountNumber("00000000"));

        assertThat(account).isNull();
    }
}
