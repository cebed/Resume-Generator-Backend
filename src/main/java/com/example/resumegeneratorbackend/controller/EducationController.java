package com.example.resumegeneratorbackend.controller;



import com.example.resumegeneratorbackend.model.Education;


import com.example.resumegeneratorbackend.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/edu")
public class EducationController {

    @Autowired
    private EducationService educationService;




    @GetMapping(value = "/all")
    public List<Education> getAll() {

        return educationService.getAll();
    }



    @PostMapping("/reg")
    public Education register(@Valid @RequestBody Education education){


        return  educationService.Register(education);

    }

/*
    @GetMapping("/Coursesebyid/{id}")
    public Courses CourseseById( @PathVariable int id){

        return  educationService.coursesById(id);

    }
*/



    @PutMapping ("/update/{id}")
    public Education updateWorkEx(@RequestBody Education u, @PathVariable int id) {

        return educationService.updateCourse(u , id);

    }


    @DeleteMapping  ("/delete/{id}")
    public String delete(@PathVariable int id) {
        System.out.println("________________---------------------");

        return educationService.deleteWorExpeience(id);

    }

}