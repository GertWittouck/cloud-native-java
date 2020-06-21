package com.gwi.accountservice.model;

import lombok.Getter;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class AccountNumber {

    @Column(name = "ACCOUNTNUMBER", unique = true)
    private final String accountNumber;


    public AccountNumber(String accountNumber) {
        this.accountNumber = validate(accountNumber);
    }

    private String validate(String accountNumber) {
        if (StringUtils.isEmpty(accountNumber)) {
            return "111-111-111-111";
        }
        return accountNumber;
    }
}
