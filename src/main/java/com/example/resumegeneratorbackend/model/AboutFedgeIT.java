package com.example.resumegeneratorbackend.model;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "AboutFedgeIT")

public class AboutFedgeIT {

    @Id
    @Getter
    @Setter

    @Column(name = "aboutFedgeIT_Id")
    private Integer aboutFedgeIT_Id;




    @Column(name = "Address")
    private String Address;
    @Column(name = "gata")
    private String gata;

    @Column(name = "postno")
    private String postno;

    public String getPostno() {
        return postno;
    }

    public void setPostno(String postno) {
        this.postno = postno;
    }

    public Integer getAboutFedgeIT_Id() {
        return aboutFedgeIT_Id;
    }

    public void setAboutFedgeIT_Id(Integer aboutFedgeIT_Id) {
        this.aboutFedgeIT_Id = aboutFedgeIT_Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGata() {
        return gata;
    }

    public void setGata(String gata) {
        this.gata = gata;
    }
}
