package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.model.Workexperience;

import com.example.resumegeneratorbackend.repository.WorkRepository;
import com.example.resumegeneratorbackend.service.WorkexperienceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@CrossOrigin
@RequestMapping("api/work")
public class WorkExController {

    @Autowired
    private WorkexperienceService workexperienceService;




    @GetMapping(value = "/all")
    public List<Workexperience> getAll() {

        return workexperienceService.getAll();
    }



    @PostMapping("/register")
    public Workexperience registerUser(@Valid @RequestBody Workexperience workexperience){

        return  workexperienceService.Register((workexperience));

    }



}