package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
    Users getById(Long id);


}
