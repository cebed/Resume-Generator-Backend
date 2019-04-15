package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.payloads.JWTLoginSuccessRes;
import com.example.resumegeneratorbackend.payloads.LoginRequests;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import com.example.resumegeneratorbackend.security.JwtTokenProvider;
import com.example.resumegeneratorbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.resumegeneratorbackend.security.SecurityCockpit.TOKEN_PREFIX;

@RestController
@CrossOrigin
@RequestMapping("api/work")
public class WorkExController {

    @Autowired
    private UserService userServices;




    @GetMapping(value = "/all")
    public List<Users> getAll() {

        return userServices.getAllUsers();
    }



    @PostMapping("/register")
    public Users registerUser(@Valid @RequestBody Users user){

        return  userServices.saveUser(user);

    }



}