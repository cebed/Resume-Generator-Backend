package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class userServices {

    @Autowired
    UsersRepository usersRepository;






    // denna metoden gör att man kan registerara sig genom enadst att skriva email.
    //anledningen är att att jag har misslyckat att skicka över ett object från front enden som motsvar
    // user

    public String Register(String email) {

        Users n = new Users();
        n.setEmail(email);
        usersRepository.save(n);
        return "hej";
    }



}
