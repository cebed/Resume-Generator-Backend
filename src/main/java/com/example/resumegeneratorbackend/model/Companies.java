package com.example.resumegeneratorbackend.model;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "Companies")

public class Companies {

    @Id
    @Getter
    @Setter
    @GeneratedValue
    @Column(name = "companies_Id")
    private Integer companies_Id;


    @Column(name = "id")
    private Integer id;

    @Column(name = "Address")
    private String Address;
    @Column(name = "gata")
    private String gata;

    @Column(name = "postno")
    private String postno;



    public Integer getCompanies_Id() {
        return companies_Id;
    }

    public void setCompanies_Id(Integer companies_Id) {
        this.companies_Id = companies_Id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
