package com.gwi.userservice.controller;

import com.gwi.userservice.model.User;
import com.gwi.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uua/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public User getAuthenticatedUser() {
        return userService.getByUsername("gwi");
    }
}
