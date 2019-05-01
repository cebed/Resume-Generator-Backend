package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Companies;
import com.example.resumegeneratorbackend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;





    public Iterable<Companies> getAll() {

        return companyRepository.findAll();
    }


    public Companies Register(Companies c) {


        return  companyRepository.save(c);
    }




    public Companies updateCompany( Companies c, int id) {
        return companyRepository.findById(id)
                .map(companies -> {
                    companies.setAddress(c.getAddress());
                    companies.setGata(c.getGata());
                    companies.setPostno(c.getPostno());
                    return companyRepository.save(companies);
                })
                .orElseGet(() -> {
                    c.setCompanies_Id(id);
                    return companyRepository.save(c);
                });

    }


    public Companies companiessById(int id){
        Companies courses = new Companies();
        for(Companies course : getAll()){
            if(course.getCompanies_Id()==id){
                courses = course;
            }
        }
        if(!courses.getCompanies_Id().equals(null)){

            return courses;

        }
        else return null;
    }





}
