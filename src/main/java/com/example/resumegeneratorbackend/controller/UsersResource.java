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

    @PostMapping(path = "/load", produces = MediaType.APPLICATION_XML_VALUE)
    public void persist(@RequestBody  Users users) {

        usersRepository.save(users);

    }

    // denna metoden gör att man kan registerara sig genom enadst att skriva email.
    //anledningen är att att jag har misslyckat att skicka över ett object från front enden som motsvar
    // user
    @PostMapping(path = "/email", produces = MediaType.APPLICATION_XML_VALUE)
    public void Register(@RequestBody String email) {
        Users n = new Users();
        n.setEmail(email);
        usersRepository.save(n);
    }




}