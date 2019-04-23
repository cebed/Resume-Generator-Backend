package com.example.resumegeneratorbackend.controller;


import com.example.resumegeneratorbackend.model.Security;
import com.example.resumegeneratorbackend.payloads.JWTLoginSuccessRes;
import com.example.resumegeneratorbackend.payloads.LoginRequests;
import com.example.resumegeneratorbackend.repository.SecurityRepository;
import com.example.resumegeneratorbackend.security.JwtTokenProvider;
import com.example.resumegeneratorbackend.service.SecurityService;
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
@RequestMapping("api/security")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private SecurityRepository securityRepository;


    @GetMapping(value = "/all")
    public List<Security> getAll() {

        return securityService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequests loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = securityService.StoreValidationErrorService(result);
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

    @GetMapping("{us_id}")
    public ResponseEntity<?> getUsByID(@PathVariable Long us_id){

        Security security = securityService.findById(us_id);
        return new ResponseEntity<Security>(security, HttpStatus.OK);
    }


    @PutMapping("/allusers/{id}")
    public Security updateUser(@RequestBody Security u, @PathVariable Long id) {


        return securityRepository.findById(id)
                .map(token -> {

                    token.setFullName(u.getFullName());
                    token.setUsername(u.getUsername());

                    return securityRepository.save(token);
                })
                .orElseGet(() -> {
                    u.setId(id);
                    return securityRepository.save(u);
                });
    }




    @PostMapping("/register")
    public Security registerUser(@Valid @RequestBody Security security){

        return  securityService.saveUser(security);

    }



/*
    @RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfGeneration(@PathVariable Long id) throws IOException {

        Users users = securityService.findById(id);

        ByteArrayInputStream bis = GeneratePdf.usersInfoPdf(users);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }







    // tillfällig login metod finns på services
    @PostMapping(path = "/login", produces = MediaType.APPLICATION_XML_VALUE)
    public String Login(@RequestBody String username) {
        return userServices.Login(username);
    }
    */
}