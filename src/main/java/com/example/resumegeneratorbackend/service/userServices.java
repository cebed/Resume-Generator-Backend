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




    public List<Users> getAllUsers() {
        List<Users> alluser = new LinkedList<>();

        for(Users u : usersRepository.findAll()){
            alluser.add(u);
        }
        return alluser;
    }

    // denna metoden gör att man kan registerara sig genom enadst att skriva email.
    //anledningen är att att jag har misslyckat att skicka över ett object från front enden som motsvar
    // user

    public String Register(String email) {

        Users n = new Users();
        n.setEmail(email);
        usersRepository.save(n);
        return "hej";
    }

    public String Login(String email) {
        String finns = "";
        for(Users u : getAllUsers()){
            if(email.equals(u.getEmail())) {
                finns =  u.getEmail();
            }
        }
        if(finns.equals("")){
            System.out.println("??????????????????????????????????????????????????????????????? ja" + finns);
            return " USER DONT EXIST";
        }
        else {
            System.out.println("??????????????????????????????????????????????????????????????? nej" + finns);
            return "USER EXIST";
        }
    }
}
