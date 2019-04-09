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

@Entity

public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Please enter full name")
    @Column(name = "fullName")
    private String fullName;



    @Email(message = "Username needs to be an email")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String username;//this instance represents the email of the user


    @NotBlank(message = "Password is required")
    @Column(name = "password")
    private String password;

    //@Transient
    //private String confirmPassword;

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

    //Constructor
    public Users(){

    }



    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    /*
    public String getConfirmPassword() {
        return confirmPassword;
    }


    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    */

    /*
    Userdetails interface methods
     */


    //denna används när man har flera roller exvis admin o user
    @Override
    @JsonIgnore //ignorerar dessa fält i postman när vi exvis får tillbaka objektet av en skapad user
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}