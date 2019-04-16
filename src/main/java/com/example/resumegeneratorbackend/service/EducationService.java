package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Education;
import com.example.resumegeneratorbackend.repository.EduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EducationService {

    @Autowired
    private EduRepository educationRepository;




    public Iterable<Education> getAll() {

        return educationRepository.findAll();
    }


    public Education registerEdu(Education education) {

        return  educationRepository.save(education);
    }


}


