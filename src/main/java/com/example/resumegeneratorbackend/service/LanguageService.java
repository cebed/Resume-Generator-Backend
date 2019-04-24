package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Languages;
import com.example.resumegeneratorbackend.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {


    @Autowired
    private LanguageRepository languageRepository;

    public List<Languages> getAll() {

        return languageRepository.findAll();
    }


    public Languages Register(Languages lang) {

        return  languageRepository.save(lang);
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
