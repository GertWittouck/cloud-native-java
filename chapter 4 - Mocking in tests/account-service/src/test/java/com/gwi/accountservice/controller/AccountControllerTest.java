package com.gwi.accountservice.controller;

import com.gwi.accountservice.model.Account;
import com.gwi.accountservice.model.AccountNumber;
import com.gwi.accountservice.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;


    @Test
    public void getUserAccountsShouldReturnAccounts() throws Exception {
        String content = "[{\"id\":null,\"username\":\"user\",\"accountNumber\":{\"accountNumber\":\"123456789\"}}]";

        given(accountService.getUserAccounts()).willReturn(
                Collections.singletonList(new Account("user", new AccountNumber("123456789")))
        );

        mockMvc.perform(get("/account/v1/user-accounts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json(content));
    }
}
