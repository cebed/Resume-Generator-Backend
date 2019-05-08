package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Courses;

import com.example.resumegeneratorbackend.service.CoursesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/course")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping(value = "/all")
    public List<Courses> getAll() {
        return coursesService.getAll();
    }
    @PostMapping("/register")
    public Courses registe(@Valid @RequestBody Courses courses){
        return  coursesService.Register(courses);
    }

    @GetMapping("/Coursesebyid/{id}")
    public Courses CourseseById( @PathVariable int id){
        return  coursesService.coursesById(id);
    }

    @PutMapping ("/update/{id}")
    public Courses updateWorkEx(@RequestBody Courses u, @PathVariable int id) {
        return coursesService.updateCourse(u , id);
    }

    @DeleteMapping  ("/delete/{id}")
    public String deleteWorExpeience(@PathVariable int id) {
        return coursesService.deleteWorExpeience(id);
    }

}