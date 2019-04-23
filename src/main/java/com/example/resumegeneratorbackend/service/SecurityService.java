package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.ExceptionHandler.UsernameOrEmailExistException;
import com.example.resumegeneratorbackend.model.Security;
import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.repository.SecurityRepository;
import com.example.resumegeneratorbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private UserRepository usersRepository;

    /*
    Service that spring security offers to Encrypt the password so nothing is readable
    No one should be able to go to database and se the password
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public Security saveOrUpdate(Security users){
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return securityRepository.save((users));
    }

    public Security findById(Long id){
        return securityRepository.getById(id);
    }



    /*
    This method takes a user, I mean the new user that we are going to create
     */


    public Security saveUser(Security newuser){



        try{
            //this encryptes the password
            newuser.setPassword(bCryptPasswordEncoder.encode(newuser.getPassword()));

            //Username has to be unique(exception handler)
            newuser.setUsername(newuser.getUsername());

            Users users = new Users();
            users.setSecurity(newuser);

            usersRepository.save(users);
            //We do not pesist or show the confirm password
            return securityRepository.save(newuser);

        }catch (Exception ex){
            throw new UsernameOrEmailExistException("Username ' " + newuser.getUsername()+ " ' already exist");
        }

    }

    public List<Security> getAllUsers() {
        return securityRepository.findAll();
    }


    /*
        This method returns a better error respone
        Can be called in controller class.
     */
    public ResponseEntity<?> StoreValidationErrorService(BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
    }

        return null;

    }

}
