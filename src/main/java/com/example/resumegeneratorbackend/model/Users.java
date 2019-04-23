package com.example.resumegeneratorbackend.model;



//import lombok.Getter;
//import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;

//needs to implement the UserDetails interface so that we can use it for some of the validation steps and the authorization steps


@Entity
public class Users  {
    // kan vi ändra detta col till users_id istället// missförstånd på andra klasser
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userid;

    @Column
    private String currentTitle;


    @Column(name="Address")
    private String address;


    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADMINORUSER")
    private boolean adminOrUser;

    @Column(name = "UserProfile")
    private String userProfile;

    @Column(name = "Image")
    private int Image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Security security;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private List<Workexperience> workExperience;

    public Users(){

    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private List<Courses> courses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private List<Education> educations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private List<Others> others;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private List<Skills> skills;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private List<Companies> companies;


    //Constructor


    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
    */


    public List<Workexperience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<Workexperience> workExperience) {
        this.workExperience = workExperience;
    }

/*
    public List<Others> getOthers() {
        return others;
    }

    public void setOthers(List<Others> others) {
        this.others = others;
    }


    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Companies> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }
*/



    public boolean isAdminOrUser() {
        return adminOrUser;
    }

    public void setAdminOrUser(boolean adminOrUser) {
        this.adminOrUser = adminOrUser;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public void setCurrentTitle(String currentTitle) {
        this.currentTitle = currentTitle;
    }

    /*
    Userdetails interface methods
     */



}