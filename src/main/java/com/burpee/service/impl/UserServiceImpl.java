package com.burpee.service.impl;

import com.burpee.dto.UserRegister;
import com.burpee.entities.User;
import com.burpee.entities.UserAuthority;
import com.burpee.repository.UserRepository;
import com.burpee.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByName(String userName) {
        return this.repository.findByUsername(userName).orElseThrow();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public void save(UserRegister newUser) {
        User user = new User(
                null,
                newUser.username(),
                passwordEncoder.encode(newUser.password()),
                List.of(UserAuthority.READ)
        );

        this.repository.save(user);
    }

}
