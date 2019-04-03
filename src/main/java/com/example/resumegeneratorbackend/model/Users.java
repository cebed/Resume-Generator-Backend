package com.example.resumegeneratorbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADMINORUSER")
    private boolean adminOrUser;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Image")
    private int Image;


    @JoinColumn(name = "EDUCATION_id", referencedColumnName = "id")
    @ManyToOne
    private Education education_id;

    @JoinColumn(name = "WORKEXPERIENCE_id", referencedColumnName = "id")
    @ManyToOne
    private Workexperience workexperience_id;

    @JoinColumn(name = "SKILLS_id", referencedColumnName = "id")
    @ManyToOne
    private Skills skills_id;

    @JoinColumn(name = "LANGUAGES_id", referencedColumnName = "id")
    @ManyToOne
    private Languages languages_id;

    @JoinColumn(name = "OTHERS_id", referencedColumnName = "id")
    @ManyToOne
    private Others others_id;

    @JoinColumn(name = "COURSES_id", referencedColumnName = "id")
    @ManyToOne
    private  Courses courses_id;






    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}