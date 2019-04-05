package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Users;

import com.example.resumegeneratorbackend.service.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private userServices userServices;

     // tillfällig register metod finns på services
    @PostMapping(path = "/register", produces = MediaType.APPLICATION_XML_VALUE)
    public String Register(@RequestBody String email) {
       return userServices.Register(email);
    }

}