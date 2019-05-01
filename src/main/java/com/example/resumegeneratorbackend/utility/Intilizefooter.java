package com.example.resumegeneratorbackend.utility;


import com.example.resumegeneratorbackend.model.Companies;
import com.example.resumegeneratorbackend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Intilizefooter {
    @Autowired
    private CompanyService companyService;

    @PostConstruct
    public void init(){
        // start your monitoring in here

        Companies companies = new Companies();

        companies.setCompanies_Id(1);
        companies.setAddress("Anders Carlssons gata 14");
        companies.setGata("Göteborg"); // city så länge
        companies.setPostno("417 55");

        companyService.Register(companies);
       // System.out.println("hej snygging");


    }
}