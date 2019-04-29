package com.example.resumegeneratorbackend.controller;


import com.example.resumegeneratorbackend.model.Languages;
import com.example.resumegeneratorbackend.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;




    @GetMapping(value = "/all")
    public Iterable<Languages> getAll(Principal principal) {

        return languageService.getAll(principal.getName());
    }



    @PostMapping("/reg")
    public Languages register(@Valid @RequestBody Languages languages, Principal principal){


        return  languageService.Register(languages, principal.getName());

    }



    @PutMapping("/update/{id}")
    public Languages updateLanguages(@RequestBody Languages l, @PathVariable int id) {

        return languageService.updateLanguages(l , id);

    }

    @GetMapping("/LanguageById/{id}")
    public Optional<Languages> LanguageById(@PathVariable int id){
        System.out.println("------------------------------------------------------------------");
        return  languageService.LanguageById(id);

    }


    @DeleteMapping  ("/delete/{id}")
    public String deleteLanguages(@PathVariable int id) {
        System.out.println("________________---------------------");

        return languageService.deleteLanguages(id);

    }
}
