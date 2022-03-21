package com.burpee.service.impl;

import com.burpee.entities.Burpee;
import com.burpee.entities.User;
import com.burpee.repository.BurpeeRepository;
import com.burpee.service.BurpeeService;
import com.burpee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurpeeServiceImpl implements BurpeeService {

    private final BurpeeRepository repository;

    private final UserService userService;

    public BurpeeServiceImpl(BurpeeRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public List<Burpee> getAll() {
        return this.repository.findAll();
    }

    @Override
    public ResponseEntity<List<Burpee>>  getAllByUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        return ResponseEntity.ok(this.repository.findAllByUserUsername(username));
    }

    @Override
    public ResponseEntity<Burpee> save(Burpee burpee) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByName( auth.getName() );

        burpee.setUser(user);
        return ResponseEntity.ok(this.repository.save(burpee));
    }

    @Override
    public ResponseEntity<Void> delete(Long burpeeId) {
        if (burpeeId == null)
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        if (!this.repository.existsById(burpeeId)){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        this.repository.deleteById(burpeeId);
        return ResponseEntity.noContent().build();
    }
}
