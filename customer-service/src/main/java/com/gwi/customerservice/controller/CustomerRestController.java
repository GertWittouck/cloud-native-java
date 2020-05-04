package com.gwi.customerservice.controller;

import com.gwi.customerservice.model.Customer;
import com.gwi.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public Collection<Customer> readAll() {
        return customerService.findAll();
    }
}
