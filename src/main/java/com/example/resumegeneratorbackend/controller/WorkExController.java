package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Workexperience;

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

        return  workexperienceService.Register(workexperience);

    }


    @GetMapping("/WorkExperienceById/{id}")
    public Workexperience WorkExperienceById( @PathVariable int id){

        return  workexperienceService.WorkExperienceById(id);

    }




    @PutMapping ("/upddateWork/{id}")
    public Workexperience updateWorkEx(@RequestBody Workexperience u, @PathVariable int id) {

       return workexperienceService.updateWorkEx(u , id);

    }


    @DeleteMapping  ("/delete/{id}")
    public String deleteWorExpeience(@PathVariable int id) {
        System.out.println("________________---------------------");

        return workexperienceService.deleteWorExpeience(id);

    }

}