package com.gwi.accountservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Embedded
    private AccountNumber accountNumber;

    public Account() {
    }

    public Account(Long id, String username, AccountNumber accountNumber) {
        this.id = id;
        this.username = username;
        this.accountNumber = accountNumber;
    }

    public Account(String username, AccountNumber accountNumber) {
        this.username = username;
        this.accountNumber = accountNumber;
    }
}
