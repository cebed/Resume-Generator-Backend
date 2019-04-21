package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Companies;
import com.example.resumegeneratorbackend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;





    public List<Companies> getAll() {

        return companyRepository.findAll();
    }


    public Companies Register(Companies c) {

        return  companyRepository.save(c);
    }




    public Companies updateCompany( Companies c, int id) {
        return companyRepository.findById(id)
                .map(companies -> {
                    companies.setName(c.getName());
                    return companyRepository.save(companies);
                })
                .orElseGet(() -> {
                    c.setCompanies_Id(id);
                    return companyRepository.save(c);
                });

    }


    public Companies companiesById(int id){
        Companies companies = new Companies();
        for(Companies comp : getAll()){
            if(comp.getCompanies_Id()==id){
                companies = comp;
            }
        }
        if(!companies.getCompanies_Id().equals(null)){

            return companies;

        }
        else return null;
    }





    public String deleteCompany(Integer id) {


        companyRepository.deleteById(id);
        return "kaos";

    }



}
