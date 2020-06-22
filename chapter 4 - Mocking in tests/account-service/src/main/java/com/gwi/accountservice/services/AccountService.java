package com.gwi.accountservice.services;

import com.gwi.accountservice.model.Account;
import com.gwi.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;

    public List<Account> getUserAccounts() {
        return Optional.ofNullable(userService.getAuthenticatedUser())
                .map(user -> accountRepository.findByUsername(user.getUsername()))
                .orElse(Collections.emptyList());

    }
}