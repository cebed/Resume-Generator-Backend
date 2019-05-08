package com.example.resumegeneratorbackend.utility;


import com.example.resumegeneratorbackend.model.AboutFedgeIT;
import com.example.resumegeneratorbackend.service.AboutFedgeITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Intilizefooter {
    @Autowired
    private AboutFedgeITService aboutFedgeITService;

    @PostConstruct
    public void init(){


        AboutFedgeIT aboutFedgeIT = new AboutFedgeIT();

        aboutFedgeIT.setAboutFedgeIT_Id(1);
        aboutFedgeIT.setAddress("Anders Carlssons gata 14");
        aboutFedgeIT.setGata("Göteborg"); // city så länge
        aboutFedgeIT.setPostno("417 55");

        aboutFedgeITService.Register(aboutFedgeIT);



    }
}