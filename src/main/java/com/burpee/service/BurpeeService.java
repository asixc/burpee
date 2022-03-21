package com.burpee.service.BurpeeService;

import com.burpee.entities.Burpee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BurpeeService {

    List<Burpee> getAll();
    ResponseEntity<List<Burpee>> getAllByUser(String emailUser);
    ResponseEntity<Burpee> save(Burpee burpee);
    ResponseEntity<Void> delete(Long burpeeId);

}
