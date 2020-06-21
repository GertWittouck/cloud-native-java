package com.gwi.userservice.service;

import com.gwi.userservice.model.User;
import com.gwi.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return new User(0L, "user", "John", "Do");
        }
        return userRepository.findByUsername(username);
    }
}
