package com.burpee.service.impl;

import com.burpee.entities.User;
import com.burpee.repository.UserRepository;
import com.burpee.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    public User getUserByName(String userName) {
        return this.repository.findByUsername(userName).orElseThrow();
    }
}
