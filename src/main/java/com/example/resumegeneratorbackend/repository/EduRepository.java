package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EduRepository extends JpaRepository<Education, Integer> {

   // Education getById(int id);


}
