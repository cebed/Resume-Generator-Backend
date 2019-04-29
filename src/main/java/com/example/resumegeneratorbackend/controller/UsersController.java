package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Users;


import com.example.resumegeneratorbackend.payloads.JWTLoginSuccessRes;
import com.example.resumegeneratorbackend.payloads.LoginRequests;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import com.example.resumegeneratorbackend.security.JwtTokenProvider;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static com.example.resumegeneratorbackend.security.SecurityCockpit.TOKEN_PREFIX;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UserService userServices;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository usersRepository;


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
        //At this point we assume that the person is authenticated
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


        return usersRepository.findById(id)
                .map(users -> {
                    users.setCurrentTitle(u.getCurrentTitle());
                    users.setFullName(u.getFullName());
                    users.setUsername(u.getUsername());
                    users.setAddress(u.getAddress());
                    users.setPhone(u.getPhone());
                    users.setUserProfile(u.getUserProfile());
                    users.setImage(u.getImage());
                    return usersRepository.save(users);
                })
                .orElseGet(() -> {
                    u.setId(id);
                    return usersRepository.save(u);
                });
    }




    @PostMapping("/auth/register")
    public Users registerUser(@Valid @RequestBody Users user){
        Users u1 = userServices.saveUser(user);
        return  u1;

    }




    @RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfGeneration(@PathVariable Long id, Principal principal) throws IOException {

        Users users = userServices.findById(id, principal.getName());

        ByteArrayInputStream bis = GeneratePdf.usersInfoPdf(users);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }






    /*
    // tillfällig login metod finns på services
    @PostMapping(path = "/login", produces = MediaType.APPLICATION_XML_VALUE)
    public String Login(@RequestBody String username) {
        return userServices.Login(username);
<<<<<<< HEAD
    }
<<<<<<< HEAD


    @RequestMapping(value="/download", method=RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException  {
        FileWriter filewriter =  null;
        try {


            String filename = "dat.txt";

            filewriter = new FileWriter(filename);
            filewriter.write("tjo");
            filewriter.flush();

            File file = new File(filename);

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
            return responseEntity;
        } catch (Exception e ) {
            return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if(filewriter!=null)
                filewriter.close();
        }
    }


=======
    */
>>>>>>> parent of a474f3b... we are able to generate blank word-docs but the sol is very bad since we cant download it first to the browser
=======
    }
    */
>>>>>>> parent of a474f3b... we are able to generate blank word-docs but the sol is very bad since we cant download it first to the browser
}