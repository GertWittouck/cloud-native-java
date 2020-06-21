package com.gwi.accountservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@Accessors(chain = true)
public class AccountNumber {

    @Column(name = "ACCOUNTNUMBER", unique = true)
    private String accountNumber;

    public AccountNumber() {
    }

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
