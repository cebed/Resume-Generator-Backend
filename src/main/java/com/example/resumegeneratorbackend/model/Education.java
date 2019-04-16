package com.example.resumegeneratorbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "Education")
public class Education {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    @NotBlank(message = "Description is required")
    private String description;

    @Column(name = "startDate")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;

    @Column(name = "EndDate")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;


    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    @ManyToOne
    private  Users USER_ID;


    //constructor
    public Education(){

    }

    public Users getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Users USER_ID) {
        this.USER_ID = USER_ID;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
