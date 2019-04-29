package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Others;
import com.example.resumegeneratorbackend.repository.OtherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherService {


    @Autowired
    private OtherRepository otherRepository;

    public Iterable<Others> getAll() {

        return otherRepository.findAll();
    }


    public Others Register(Others others) {

        return  otherRepository.save(others);
    }


    public Optional<Others> otherCompetencesById(int id){
        return otherRepository.findById(id);
    }

    public Others updateOthers( Others o, int id) {
        return otherRepository.findById(id)
                .map(others -> {
                    others.setTitle(o.getTitle());
                    others.setDescription(o.getDescription());
                    return otherRepository.save(others);
                })
                .orElseGet(() -> {
                    o.setOthers_Id(id);
                    return otherRepository.save(o);
                });

    }


    public String deleteOthers(Integer id) {


        otherRepository.deleteById(id);
        return "kaos";

    }





}
