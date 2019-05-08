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


    public Education Register(Education Education) {

        return educationRepository.save(Education);
    }

    public Education updateCourse(Education u, int id) {
        return educationRepository.findById(id)
                .map(Education -> {
                    Education.setTitle(u.getTitle());
                    Education.setDescription(u.getDescription());
                    Education.setEnd_date(u.getEnd_date());
                    Education.setStart_date(u.getStart_date());
                    return educationRepository.save(u);
                })
                .orElseGet(() -> {
                    u.setEducation_id(id);
                    return educationRepository.save(u);
                });

    }


    public Optional<Education> EducationById(int id) {
        return educationRepository.findById(id);
    }

    public String deleteWorExpeience(Integer id) {
        educationRepository.deleteById(id);
        return "kaos";

    }


}


