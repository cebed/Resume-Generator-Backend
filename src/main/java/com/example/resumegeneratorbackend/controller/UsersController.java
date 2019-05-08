package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.AboutFedgeIT;
import com.example.resumegeneratorbackend.model.Users;


import com.example.resumegeneratorbackend.payloads.JWTLoginSuccessRes;
import com.example.resumegeneratorbackend.payloads.LoginRequests;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import com.example.resumegeneratorbackend.security.JwtTokenProvider;
import com.example.resumegeneratorbackend.service.AboutFedgeITService;
import com.example.resumegeneratorbackend.service.UserService;
import com.example.resumegeneratorbackend.utility.GeneratePdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.*;
import java.security.Principal;

import static com.example.resumegeneratorbackend.security.SecurityCockpit.TOKEN_PREFIX;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UserService userServices;
    @Autowired
    private AboutFedgeITService aboutFedgeITService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping(value = "/all")
    public Iterable<Users> getAll(Principal principal) {

        return userServices.getAllUsers(principal.getName());
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequests loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = userServices.StoreValidationErrorService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )

        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessRes(true, jwt));
    }
    @GetMapping("{us_id}")
    public ResponseEntity<?> getUsByID(@PathVariable Long us_id, Principal principal){

        Users users = userServices.findById(us_id, principal.getName());
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }

    @PutMapping("/allusers/{id}")
    public Users updateUser(@RequestBody Users u, @PathVariable Long id) {

                return userServices.updateUserInformatio(u,id);

    }
    @PostMapping("/auth/register")
    public Users registerUser(@Valid @RequestBody Users user){
        Users u1 = userServices.saveUser(user);
        return  u1;

    }
    @RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfGeneration(@PathVariable Long id, Principal principal) throws IOException {
        Users users = userServices.findById(id, principal.getName());
        AboutFedgeIT com = aboutFedgeITService.fEdgeById(1);
        ByteArrayInputStream bis = GeneratePdf.usersInfoPdf(users, com);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}