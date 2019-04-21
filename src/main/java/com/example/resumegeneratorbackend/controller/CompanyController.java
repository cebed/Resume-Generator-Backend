package com.example.resumegeneratorbackend.controller;


import com.example.resumegeneratorbackend.model.Companies;
import com.example.resumegeneratorbackend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;




    @GetMapping(value = "/all")
    public List<Companies> getAll() {

        return companyService.getAll();
    }



    @PostMapping("/register")
    public Companies register(@Valid @RequestBody Companies companies){

        return  companyService.Register(companies);

    }


    @GetMapping("/Companiesbyid/{id}")
    public Companies CompaniesById( @PathVariable int id){

        return  companyService.companiesById(id);

    }




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
