package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.ExceptionHandler.UsernameOrEmailExistException;
import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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


    /*
    This method takes a user, I mean the new user that we are going to create
     */
    public Users saveUser(Users newuser){



        try{
            //this encryptes the password
            newuser.setPassword(bCryptPasswordEncoder.encode(newuser.getPassword()));

            //Username has to be unique(exception handler)
            newuser.setUsername(newuser.getUsername());

            //We do not pesist or show the confirm password
            return usersRepository.save(newuser);

        }catch (Exception ex){
            throw new UsernameOrEmailExistException("Username ' " + newuser.getUsername()+ " ' already exist");
        }

    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }



    // denna metoden gör att man kan registerara sig genom enadst att skriva email.
    //anledningen är att att jag har misslyckat att skicka över ett object från front enden som motsvar
    // user

    /*
    public String Register(String username) {

        Users n = new Users();
        n.setUsername(username);
        usersRepository.save(n);
        return "hej";
    }
    */
    /*
    public String Login(String username) {
        String finns = "";
        for(Users u : getAllUsers()){
            if(username.equals(u.getUsername())) {
                finns =  u.getUsername();
            }
        }
        if(finns.equals("")){
            System.out.println("??????????????????????????????????????????????????????????????? ja" + finns);
            return " USER DONT EXIST";
        }
        else {
            System.out.println("??????????????????????????????????????????????????????????????? nej" + finns);
            return "USER EXIST";
        }
    }
    */
}
