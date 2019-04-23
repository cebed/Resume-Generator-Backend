package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Security, Long> {

    Security findByUsername(String username);
    Security getById(Long id);


}
