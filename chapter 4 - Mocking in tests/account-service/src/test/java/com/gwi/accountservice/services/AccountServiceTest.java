package com.gwi.accountservice.services;

import com.gwi.accountservice.model.Account;
import com.gwi.accountservice.model.AccountNumber;
import com.gwi.accountservice.model.User;
import com.gwi.accountservice.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private UserService userService;

    @MockBean
    private AccountRepository accountRepository;

    private AccountService accountService;

    @Before
    public void setUp() {
        accountService = new AccountService(accountRepository, userService);
    }

    @Test
    public void getUserAccountsReturnsSingleAccount() {
        given(accountRepository.findByUsername("user")).willReturn(
                Collections.singletonList(new Account("user", new AccountNumber("123456789")))
        );
        given(userService.getAuthenticatedUser()).willReturn(
                new User(0L, "user", "John", "Do")
        );

        List<Account> actual = accountService.getUserAccounts();

        assertThat(actual).size().isEqualTo(1);
        assertThat(actual.get(0).getUsername()).isEqualTo("user");
        assertThat(actual.get(0).getAccountNumber()).isEqualTo(new AccountNumber("123456789"));
    }
}