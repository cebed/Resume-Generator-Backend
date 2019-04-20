package com.example.resumegeneratorbackend.controller;

import com.example.resumegeneratorbackend.model.Others;
import com.example.resumegeneratorbackend.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/others")
public class OthersController {


    @Autowired
    private OtherService otherService;




    @GetMapping(value = "/all")
    public List<Others> getAll() {

        return otherService.getAll();
    }



    @PostMapping("/reg")
    public Others register(@Valid @RequestBody Others othr){


        return  otherService.Register(othr);

    }



    @PutMapping("/update/{id}")
    public Others updateOthers(@RequestBody Others o, @PathVariable int id) {

        return otherService.updateOthers(o , id);

    }


    @DeleteMapping  ("/delete/{id}")
    public String delete(@PathVariable int id) {
        System.out.println("________________---------------------");

        return otherService.deleteOthers(id);

    }
}
