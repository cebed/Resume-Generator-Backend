package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Others;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OtherRepository extends CrudRepository<Others, Integer> {

    @Override
    Optional<Others> findById(Integer integer);

    Others getById(int id);


}
