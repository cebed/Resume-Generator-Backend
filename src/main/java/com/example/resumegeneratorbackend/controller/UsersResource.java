package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Users;

import com.example.resumegeneratorbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll() {

        return usersRepository.findAll();
    }



    // denna metoden gör att man kan registerara sig genom enadst att skriva email.
    //anledningen är att att jag har misslyckat att skicka över ett object från front enden som motsvar
    // user
    @PostMapping(path = "/register", produces = MediaType.APPLICATION_XML_VALUE)
    public String Register(@RequestBody String email) {
        Users n = new Users();
        n.setEmail(email);

        usersRepository.save(n);



        return "hej";
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_XML_VALUE)
    public String Login(@RequestBody String email) {
        String finns = " ";
        for(Users u : usersRepository.findAll()){
            if(email.equals(u.getEmail())) {
                finns =  u.getEmail();
            }

        }
        System.out.println("???????????????????????????????????????????????????????????????" + finns);
        return "response";
    }




}