package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Workexperience;
import com.example.resumegeneratorbackend.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkexperienceService {

    @Autowired
    private WorkRepository workRepository;





    public List<Workexperience> getAll() {

        return workRepository.findAll();
    }


    public Workexperience Register(Workexperience workexperience) {

        return  workRepository.save(workexperience);
    }




    public Workexperience updateWorkEx( Workexperience u, int id) {
        return workRepository.findById(id)
                .map(Workexperience -> {
                    Workexperience.setTitle(u.getTitle());
                    Workexperience.setDescription(u.getDescription());
                    Workexperience.setEnd_date(u.getEnd_date());
                    Workexperience.setStart_date(u.getStart_date());
                    return workRepository.save(Workexperience);
                })
                .orElseGet(() -> {
                    u.setId_workExperience(id);
                    return workRepository.save(u);
                });

    }

    public Workexperience WorkExperienceById(int id){
        Workexperience workexperiences = new Workexperience();
       for(Workexperience workexperience : getAll()){
            if(workexperience.getId_workExperience()==id){
                workexperiences = workexperience;
            }
       }
       if(!workexperiences.getId_workExperience().equals(null)){

           return workexperiences;

       }
       else return null;
    }


    public String deleteWorExpeience(Integer id) {


        workRepository.deleteById(id);
        return "kaos";

    }



}
