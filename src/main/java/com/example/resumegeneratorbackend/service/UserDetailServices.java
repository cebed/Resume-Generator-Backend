package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Once we have registred a user then we want to make sure that the person actually exists
 *
 */
@Service
public class UserDetailServices implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        //if the user is null means that we didnt found a user and spring security have UserNameNot..Exception
        // this to tell that make it clear that user was not found
        //this indicates that we are trying to log in with a user and before we even check that the password is correct we first check if user exist
        if(users==null) new UsernameNotFoundException("User not found");
        return users;
    }


    //this is needed when filtering the token
    @Transactional
    public Users loadUserById(Long id){
        Users users = usersRepository.getById(id);
        if(users==null) new UsernameNotFoundException("User not found");
        return users;

    }
}
