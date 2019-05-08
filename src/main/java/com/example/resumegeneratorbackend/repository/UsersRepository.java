package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    @Override
    Iterable<Users> findAll();
    Users findByUsername(String username);
    Users getById(Long id);

}
