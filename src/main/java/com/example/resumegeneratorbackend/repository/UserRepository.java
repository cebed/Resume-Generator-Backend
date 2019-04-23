package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Security;
import com.example.resumegeneratorbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    //Security findByUsername(String username);
    //Users getById(Long id);
    Users getByUserid(Long id);

}
