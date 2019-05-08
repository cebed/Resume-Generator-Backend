package com.example.resumegeneratorbackend.controller;


import com.example.resumegeneratorbackend.model.AboutFedgeIT;
import com.example.resumegeneratorbackend.service.AboutFedgeITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/company")
public class AboutFedgeITController {

    @Autowired
    private AboutFedgeITService aboutFedgeITService;


    @PostMapping ("/update")
    public AboutFedgeIT updateCompany(@RequestBody AboutFedgeIT a) {

        return aboutFedgeITService.updateFedgeIT(a , 1);

    }

    @GetMapping("/byId/{id}")
    public AboutFedgeIT fetchById(@PathVariable int id){

        return  aboutFedgeITService.fEdgeById(id);

    }








}
