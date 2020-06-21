package com.gwi.accountservice.controller;

import com.gwi.accountservice.model.Account;
import com.gwi.accountservice.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account/v1")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/user-accounts")
    public List<Account> getUserAccounts() {
        return accountService.getUserAccounts();
    }
}
