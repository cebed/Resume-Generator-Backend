package com.example.resumegeneratorbackend.repository;


import com.example.resumegeneratorbackend.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
