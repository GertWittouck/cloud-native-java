package com.gwi.customerservice.service;

import com.gwi.customerservice.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {

    private final JdbcTemplate jdbcTemplate;

    public CustomerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<Customer> findAll() {
        RowMapper<Customer> rowMapper = (rs, i) -> new Customer(rs.getLong("ID"), rs.getString("EMAIL"));
        return jdbcTemplate.query("select * from CUSTOMERS", rowMapper);
    }
}
