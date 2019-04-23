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
public class UserService {

    @Autowired
    private UserRepository userRepository;





    public List<Users> getAll() {

        return userRepository.findAll();
    }


    public Users Register(Users users) {

        return  userRepository.save(users);
    }

    public Users findById(Long id){
        return userRepository.getByUserid(id);
    }


/*
    public Users update( Users u, int id) {
        return userRepository.findById(id)
                .map(Workexperience -> {
                    Workexperience.setTitle(u.getTitle());
                    Workexperience.setDescription(u.getDescription());
                    Workexperience.setEnd_date(u.getEnd_date());
                    Workexperience.setStart_date(u.getStart_date());
                    return userRepository.save(Workexperience);
                })
                .orElseGet(() -> {
                    u.setId_workExperience(id);
                    return userRepository.save(u);
                });

    }

    */


    public String delete(Long id) {


        userRepository.deleteById(id);
        return "kaos";

    }



}
