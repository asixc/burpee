package com.burpee.service;

import com.burpee.entities.Burpee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BurpeeService {

    List<Burpee> getAll();
    ResponseEntity<List<Burpee>> getAllByUser();
    ResponseEntity<Burpee> save(Burpee burpee);
    ResponseEntity<Void> delete(Long burpeeId);

}
