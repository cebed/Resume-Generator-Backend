package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.AboutFedgeIT;
import com.example.resumegeneratorbackend.repository.AboutFedgeITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutFedgeITService {

    @Autowired
    private AboutFedgeITRepository aboutFedgeITRepository;
    public Iterable<AboutFedgeIT> getAll() {

        return aboutFedgeITRepository.findAll();
    }
    public AboutFedgeIT Register(AboutFedgeIT aboutFedgeIT) {


        return aboutFedgeITRepository.save(aboutFedgeIT);
    }

    public AboutFedgeIT updateFedgeIT(AboutFedgeIT a, int id) {
        return aboutFedgeITRepository.findById(id)
                .map(aboutFedgeIT -> {
                    aboutFedgeIT.setAddress(a.getAddress());
                    aboutFedgeIT.setGata(a.getGata());
                    aboutFedgeIT.setPostno(a.getPostno());
                    return aboutFedgeITRepository.save(aboutFedgeIT);
                })
                .orElseGet(() -> {
                    a.setAboutFedgeIT_Id(id);
                    return aboutFedgeITRepository.save(a);
                });
    }

    public AboutFedgeIT fEdgeById(int id) {
        AboutFedgeIT aboutFedgeIT = new AboutFedgeIT();
        for (AboutFedgeIT fedgeIT : getAll()) {
            if (fedgeIT.getAboutFedgeIT_Id() == id) {
                aboutFedgeIT = fedgeIT;
            }
        }
        if (!aboutFedgeIT.getAboutFedgeIT_Id().equals(null)) {

            return aboutFedgeIT;

        } else return null;
    }

}
