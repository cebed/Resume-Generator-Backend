package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.AboutFedgeIT;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AboutFedgeITRepository extends CrudRepository<AboutFedgeIT, Integer> {
    @Override
    Optional<AboutFedgeIT> findById(Integer integer);

}
