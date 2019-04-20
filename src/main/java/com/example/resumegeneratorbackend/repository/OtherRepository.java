package com.example.resumegeneratorbackend.repository;

import com.example.resumegeneratorbackend.model.Others;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherRepository extends JpaRepository<Others, Integer> {

    Others getById(int id);


}
