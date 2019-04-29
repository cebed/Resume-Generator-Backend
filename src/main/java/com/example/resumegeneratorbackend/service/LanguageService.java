package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Languages;
import com.example.resumegeneratorbackend.model.Users;
import com.example.resumegeneratorbackend.repository.LanguageRepository;
import com.example.resumegeneratorbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {


    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private UsersRepository usersRepository;


    public Iterable<Languages> getAll(String username) {

        return languageRepository.findAllByOwner(username);
    }




    public Languages Register(Languages lang, String username) {
            Users users = usersRepository.findByUsername(username);
            lang.setUsers(users);
            lang.setOwner(users.getUsername());
        return  languageRepository.save(lang);
    }

    public Optional<Languages> LanguageById(int id){
        return languageRepository.findById(id);
    }





    public Languages updateLanguages( Languages l, int id) {
        return languageRepository.findById(id)
                .map(languages -> {
                    languages.setTitle(l.getTitle());
                    languages.setLevel(l.getLevel());
                    return languageRepository.save(languages);
                })
                .orElseGet(() -> {
                    l.setId_language(id);
                    return languageRepository.save(l);
                });

    }


    public String deleteLanguages(Integer id) {


        languageRepository.deleteById(id);
        return "kaos";

    }





}
