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
public class Users implements UserDetails {
// kan vi ändra detta col till users_id istället// missförstånd på andra klasser
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String currentTitle;



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


    @Column(name="Address")
    private String address;


    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADMINORUSER")
    private boolean adminOrUser;

    public boolean isAdminOrUser() {
        return adminOrUser;
    }

    public void setAdminOrUser(boolean adminOrUser) {
        this.adminOrUser = adminOrUser;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Column(name = "UserProfile")
    private String userProfile;

    @Column(name = "Image")
    private String Image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Workexperience> workExperience;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Courses> courses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Education> educations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Others> others;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Skills> skills;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Companies> companies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Languages> languages;



    //Constructor
    public Users(){

    }

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

    public List<Workexperience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<Workexperience> workExperience) {
        this.workExperience = workExperience;
    }


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

    public String getUsername() {

        return username;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
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