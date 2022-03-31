package com.burpee.service;

import com.burpee.dto.UserRegister;
import com.burpee.entities.User;

import java.util.Optional;

public interface UserService {

    User getUserByName(String userName);

    Optional<User> findByUsername(String username);

    void save(UserRegister newUser);
}
