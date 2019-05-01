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


    @PostMapping ("/update")
    public Companies updateCompany(@RequestBody Companies c) {

        return companyService.updateCompany(c , 1);

    }







}
