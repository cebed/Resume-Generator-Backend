package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository  extends JpaRepository<Skills, Integer> {

    Skills getById(int id);
}
