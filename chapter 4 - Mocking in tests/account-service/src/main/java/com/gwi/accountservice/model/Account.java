package com.gwi.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Embedded
    private AccountNumber accountNumber;
}
