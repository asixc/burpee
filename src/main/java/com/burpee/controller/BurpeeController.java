package com.burpee.controller;

import com.burpee.entities.Burpee;
import com.burpee.service.BurpeeService.BurpeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burpee")
public class BurpeeController {

    private final BurpeeService service;

    public BurpeeController(BurpeeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Burpee>> findAllByCurrentUser()/* throws UnauthenticatedException */{
        return this.service.getAllByUser("test");
    }

    @PostMapping()
    public ResponseEntity<Burpee> save(@RequestBody Burpee burpee) {
        return this.service.save(burpee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Burpee> update(@PathVariable Long id, @RequestBody Burpee burpee) {
        return this.service.save(burpee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return this.service.delete(id);
    }
}
