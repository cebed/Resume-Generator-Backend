package com.example.resumegeneratorbackend.model;





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
public class Security implements UserDetails {
    // kan vi ändra detta col till users_id istället// missförstånd på andra klasser
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;



    @NotBlank(message = "Please enter full name")
    @Column(name = "fullName")
    private String fullName;



    @Email(message = "Username needs to be an email")
    @NotBlank(message = "Email is required")
    @Column(unique = true, length = 250)
    private String username;//this instance represents the email of the user


    @NotBlank(message = "Password is required")
    @Column(name = "password")
    private String password;





    //Constructor
    public Security(){

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
    Userdetails interface methods
     */


    //denna används när man har flera roller exvis admin o user
    @Override
    @JsonIgnore //ignorerar dessa fält i postman när vi exvis får tillbaka objektet av en skapad user
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    //this is set to true because if it false then it is used to handle accounts that expires becasue of payment
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