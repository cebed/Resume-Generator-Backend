package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Skills;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SkillRepository  extends CrudRepository<Skills, Integer> {
    @Override
    Optional<Skills> findById(Integer integer);
}
