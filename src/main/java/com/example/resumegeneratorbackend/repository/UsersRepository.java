package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    @Override
    Iterable<Users> findAll();

    //Iterable<Users> findAllByOwner(String username);



    Users findByUsername(String username);
    Users getById(Long id);


}
