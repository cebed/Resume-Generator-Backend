package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.ExceptionHandler.UsernameOrEmailExistException;
import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.model.Workexperience;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import com.example.resumegeneratorbackend.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class WorkexperienceService {

    @Autowired
    private WorkRepository workRepository;





    public List<Workexperience> getAll() {

        return workRepository.findAll();
    }


    public Workexperience Register(Workexperience workexperience) {

        return  workRepository.save(workexperience);
    }


    public List<Workexperience> getbyid(int id) {
        List<Workexperience> byId = new LinkedList<>();
        for(Workexperience u : getAll()){
            if(id==u.getUSER_ID().getId()) {

                byId.add(u);
            }
        }
        if(!byId.isEmpty()){
            System.out.println("??????????????????????????????????????????????????????????????? ja" );
            return byId;
        }
        else {
            System.out.println("??????????????????????????????????????????????????????????????? nej" );
            return null;
        }
    }

}
