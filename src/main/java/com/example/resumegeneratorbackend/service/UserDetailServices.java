package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Security;
import com.example.resumegeneratorbackend.repository.SecurityRepository;

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
    private SecurityRepository securityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Security security = securityRepository.findByUsername(username);
        //if the user is null means that we didnt found a user and spring security have UserNameNot..Exception
        // this to tell that make it clear that user was not found
        //this indicates that we are trying to log in with a user and before we even check that the password is correct we first check if user exist
        if(security==null) new UsernameNotFoundException("User not found");
        return security;
    }


    //this is needed when filtering the token
    @Transactional
    public Security loadUserById(Long id){
        Security security = securityRepository.getById(id);
        if(security==null) new UsernameNotFoundException("User not found");
        return security;

    }
}
