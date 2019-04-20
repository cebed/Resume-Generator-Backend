package com.example.resumegeneratorbackend.controller;


import com.example.resumegeneratorbackend.model.Languages;
import com.example.resumegeneratorbackend.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;




    @GetMapping(value = "/all")
    public List<Languages> getAll() {

        return languageService.getAll();
    }



    @PostMapping("/reg")
    public Languages register(@Valid @RequestBody Languages languages){


        return  languageService.Register(languages);

    }



    @PutMapping("/update/{id}")
    public Languages updateLanguages(@RequestBody Languages l, @PathVariable int id) {

        return languageService.updateLanguages(l , id);

    }


    @DeleteMapping  ("/delete/{id}")
    public String deleteLanguages(@PathVariable int id) {
        System.out.println("________________---------------------");

        return languageService.deleteLanguages(id);

    }
}
