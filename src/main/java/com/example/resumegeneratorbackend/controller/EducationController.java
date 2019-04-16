package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Education;
import com.example.resumegeneratorbackend.service.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("api/edu")
@CrossOrigin
public class EducationController {


    @Autowired
    private EducationService educationService;



    @GetMapping(value = "/all")
    public Iterable<Education> getAll() {

        return educationService.getAll();
    }



    @PostMapping("/register")
    public Education registerUser(@Valid @RequestBody Education education){

        return  educationService.registerEdu(education);

    }




}

