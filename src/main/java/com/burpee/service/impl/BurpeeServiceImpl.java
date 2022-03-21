package com.burpee.service.impl;

import com.burpee.entities.Burpee;
import com.burpee.repository.BurpeeRepository;
import com.burpee.service.BurpeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurpeeServiceImpl implements BurpeeService {

    private final BurpeeRepository repository;

    public BurpeeServiceImpl(BurpeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Burpee> getAll() {
        return this.repository.findAll();
    }

    @Override
    public ResponseEntity<List<Burpee>>  getAllByUser(String emailUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       /* if(auth == null)
            throw new UnauthenticatedException("Authentication not found!");

        String username = auth.getName();
        return this.repository.findAllByUserUsername("email@test.com");*/
        final var burpees = this.repository.findAll();

        if (burpees.size() == 0)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(burpees);
    }

    @Override
    public ResponseEntity<Burpee> save(Burpee burpee) {
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
