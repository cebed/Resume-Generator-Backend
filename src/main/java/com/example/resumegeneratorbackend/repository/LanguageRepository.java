package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Languages, Integer> {

   // Languages getById(int id);
}
