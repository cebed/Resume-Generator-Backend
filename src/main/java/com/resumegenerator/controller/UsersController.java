package com.resumegenerator.controller;


import org.springframework.web.bind.annotation.*;



@RestController

public class UsersController {

    @RequestMapping("/hello")

    public String sayHi() {

        return "Hi";
    }

}
