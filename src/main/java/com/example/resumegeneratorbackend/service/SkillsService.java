package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Skills;
import com.example.resumegeneratorbackend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {


    @Autowired
    private SkillRepository skillRepository;

    public List<Skills> getAll() {

        return skillRepository.findAll();
    }


    public Skills Register(Skills skills) {

        return  skillRepository.save(skills);
    }




    public Skills updateSkills( Skills s, int id) {
        return skillRepository.findById(id)
                .map(everySkill -> {
                    everySkill.setTitle(s.getTitle());
                    everySkill.setLevel(s.getLevel());
                    return skillRepository.save(everySkill);
                })
                .orElseGet(() -> {
                    s.setSkills_Id(id);
                    return skillRepository.save(s);
                });

    }


    public String deleteSkills(Integer id) {


        skillRepository.deleteById(id);
        return "kaos";

    }
}
