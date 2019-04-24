package com.example.resumegeneratorbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;


@Entity
@Table(name = "Education")
public class Education {


    @Id
    @GeneratedValue
    @Column(name = "education_id")
    private int education_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private String start_date;

    @Column(name = "EndDate")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private String end_date;

    // observera att detta fält referar till user objectet
    @Column(name = "id")
    private Integer id;


    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //constructor
    public Education(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
