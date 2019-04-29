package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Languages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends CrudRepository<Languages, Integer> {

    @Override
    Iterable<Languages> findAll();

    Iterable<Languages> findAllByOwner(String username);

    @Override
    Optional<Languages> findById(Integer integer);

    Languages getById(int id);
}
