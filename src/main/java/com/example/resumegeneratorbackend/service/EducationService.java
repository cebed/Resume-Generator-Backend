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

    public List<Education> getAll() {

        return educationRepository.findAll();
    }


    public Education Register(Education Education) {

        return  educationRepository.save(Education);
    }




    public Education updateCourse( Education u, int id) {
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


/*
    public Education EducationById(int id){
        Education education = new Education();
        for(Education course : getAll()){
            if(course.getEducation_id()==id){
                education = course;
            }
        }
        if(!education.getEducation_id().equals(null)){

            return education;

        }
        else return null;
    }
*/

    public String deleteWorExpeience(Integer id) {


        educationRepository.deleteById(id);
        return "kaos";

    }










}


