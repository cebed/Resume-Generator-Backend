package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.model.Workexperience;

import com.example.resumegeneratorbackend.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@CrossOrigin
@RequestMapping("api/work")
public class WorkExController {

    @Autowired
    private WorkRepository workRepository;




    @GetMapping(value = "/all")
    public List<Workexperience> getAll() {

        return workRepository.findAll();
    }



    @PostMapping("/register")
    public Workexperience registerUser(@Valid @RequestBody Workexperience workexperience){

        return  workRepository.save(workexperience);

    }



}