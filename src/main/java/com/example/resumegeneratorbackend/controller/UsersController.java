package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Users;


import com.example.resumegeneratorbackend.payloads.JWTLoginSuccessRes;
import com.example.resumegeneratorbackend.payloads.LoginRequests;
import com.example.resumegeneratorbackend.security.JwtTokenProvider;
import com.example.resumegeneratorbackend.service.UserService;
import com.example.resumegeneratorbackend.service.StoreValidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.validation.Valid;
import java.util.List;

import static com.example.resumegeneratorbackend.security.SecurityCockpit.TOKEN_PREFIX;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UserService userServices;

    @Autowired
    private StoreValidationErrorService storeValidationErrorService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping(value = "/all")
    public List<Users> getAll() {

        return userServices.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequests loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = storeValidationErrorService.StoreValidationErrorService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )

        );
        //At this point we assume that the person is authenticated
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessRes(true, jwt));
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Users user, BindingResult result){

        ResponseEntity<?> errorMap = storeValidationErrorService.StoreValidationErrorService((result));
        if(errorMap!= null)
            return errorMap;

        Users newuser = userServices.saveUser(user);

        return new ResponseEntity<Users>(newuser, HttpStatus.CREATED);


    }





    /*
     // tillfällig register metod finns på services
    @PostMapping(path = "/register", produces = MediaType.APPLICATION_XML_VALUE)
    public String Register(@RequestBody String username) {
       return userServices.Register(username);
    }
    */


    /*
    // tillfällig login metod finns på services
    @PostMapping(path = "/login", produces = MediaType.APPLICATION_XML_VALUE)
    public String Login(@RequestBody String username) {
        return userServices.Login(username);
    }
    */
}