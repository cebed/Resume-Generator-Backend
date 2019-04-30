package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Companies;
import com.example.resumegeneratorbackend.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository  extends CrudRepository<Companies, Integer> {
    @Override
    Optional<Companies> findById(Integer integer);

}
