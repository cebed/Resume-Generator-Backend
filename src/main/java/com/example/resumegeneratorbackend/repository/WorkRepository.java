package com.example.resumegeneratorbackend.repository;


import com.example.resumegeneratorbackend.model.Workexperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Workexperience, Integer> {




}
