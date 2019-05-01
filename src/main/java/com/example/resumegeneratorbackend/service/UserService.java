package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.ExceptionHandler.UsernameOrEmailExistException;
import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.repository.UsersRepository;
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
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    /*
    Service that spring security offers to Encrypt the password so nothing is readable
    No one should be able to go to database and se the password
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public Users saveOrUpdate(Users users){
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return usersRepository.save((users));
    }

    public Users findById(Long id, String username) {
        Users users = usersRepository.getById(id);
        if (!users.getUsername().equals(username)&& users.isAdminOrUser()==true)  {
            System.out.println("Permission denied");
            return null;
        }

        return users;
    }



    /*
    This method takes a user, I mean the new user that we are going to create
     */


    public Users saveUser(Users newuser){



        try{

            newuser.setTheOwner(newuser.getUsername());
            //this encryptes the password
            newuser.setPassword(bCryptPasswordEncoder.encode(newuser.getPassword()));

            //Username has to be unique(exception handler)
            newuser.setUsername(newuser.getUsername());
            newuser.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png");
            newuser.setCurrentTitle("");
            newuser.setUserProfile("");
            if(newuser.getUsername().equals("nurhusein11@gmail.com") || newuser.getUsername().equals("cebed@chalmers.se") ||newuser.getFullName().equals("Fredrik Lunde")){
                newuser.setAdminOrUser(true);
            }

            //We do not pesist or show the confirm password
            return usersRepository.save(newuser);

        }catch (Exception ex){
            throw new UsernameOrEmailExistException("Username ' " + newuser.getUsername()+ " ' already exist");
        }

    }

    public Iterable<Users> getAllUsers(String username) {
        Users users = usersRepository.findByUsername(username);
        boolean up = users.isAdminOrUser();
        if (users.getTheOwner().equals(username) && up==false)
        {
            System.out.println("You are not allowed to get all users");
            return null;

        }

        return usersRepository.findAll();
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
