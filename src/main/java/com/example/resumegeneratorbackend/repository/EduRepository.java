package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Education;
import org.springframework.data.repository.CrudRepository;

public interface EduRepository extends CrudRepository<Education, Long> {


    @Override
    Iterable<Education> findAll();

}
