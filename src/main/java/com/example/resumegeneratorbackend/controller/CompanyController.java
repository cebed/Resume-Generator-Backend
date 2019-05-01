package com.example.resumegeneratorbackend.controller;


import com.example.resumegeneratorbackend.model.Companies;
import com.example.resumegeneratorbackend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @PutMapping ("/update/{id}")
    public Companies updateCompany(@RequestBody Companies c, @PathVariable int id) {

        return companyService.updateCompany(c , id);

    }


    @DeleteMapping  ("/delete/{id}")
    public String deleteCompany(@PathVariable int id) {
        System.out.println("________________---------------------");


        return companyService.deleteCompany(id);

    }






}
