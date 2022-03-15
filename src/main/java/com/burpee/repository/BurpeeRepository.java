package com.burpee.repository;

import com.burpee.entities.Burpee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BurpeeRepository extends JpaRepository<Burpee, Long> {
    List<Burpee> findAllByUserUsername(String username);

    //List<Burpee> findAllByUsername(String emailUser);
}
