package com.example.resumegeneratorbackend.controller;


import com.example.resumegeneratorbackend.model.Skills;
import com.example.resumegeneratorbackend.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/skills")
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    @GetMapping(value = "/all")
    public Iterable<Skills> getAll() {
        return skillsService.getAll();
    }

    @PostMapping("/reg")
    public Skills register(@Valid @RequestBody Skills skills){
        return  skillsService.Register(skills);
    }

    @PutMapping("/update/{id}")
    public Skills updateOthers(@RequestBody Skills s, @PathVariable int id) {
        return skillsService.updateSkills(s , id);
    }

    @GetMapping("/getSkillsById/{id}")
    public Optional<Skills> skillsById(@PathVariable int id){
        return  skillsService.skillsById(id);
    }


    @DeleteMapping  ("/delete/{id}")
    public String deleteSkills(@PathVariable int id) {
        return skillsService.deleteSkills(id);
    }
}
