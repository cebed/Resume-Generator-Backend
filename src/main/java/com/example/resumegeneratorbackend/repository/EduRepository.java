package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EduRepository extends CrudRepository<Education, Integer> {
    @Override
    Optional<Education> findById(Integer integer);
}
