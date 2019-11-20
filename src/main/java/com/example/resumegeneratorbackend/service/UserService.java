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
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public Users updateUserInformatio(Users u,  Long id){
        return usersRepository.findById(id)
                .map(users -> {
                    users.setCurrentTitle(u.getCurrentTitle());
                    users.setFullName(u.getFullName());
                    users.setUsername(u.getUsername());
                    users.setAddress(u.getAddress());
                    users.setPhone(u.getPhone());
                    users.setUserProfile(u.getUserProfile());
                    users.setImage(u.getImage());
                    users.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
                    return usersRepository.save(users);
                })
                .orElseGet(() -> {
                    u.setId(id);
                    return usersRepository.save(u);
                });
    }

    public Users findById(Long id, String username) {
        Users users = usersRepository.getById(id);
        Users isadmin = usersRepository.findByUsername(username);
        if (users.getUsername().equals(username) || isadmin.isAdminOrUser()==true)  {
            return users;
        }

        return null;
    }

    public Users findByEmail(String email){
        return  usersRepository.findByUsername(email);
    }



    public Users saveUser(Users newuser){
        try{

            newuser.setTheOwner(newuser.getUsername());
            newuser.setPassword(bCryptPasswordEncoder.encode(newuser.getPassword()));
            newuser.setAdminOrUser(true);
            newuser.setUsername(newuser.getUsername());
            newuser.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png");
            newuser.setCurrentTitle("");
            newuser.setUserProfile("");
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
