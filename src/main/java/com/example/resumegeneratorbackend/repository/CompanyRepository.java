package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Companies, Integer> {
    Companies getById(int id);

}
