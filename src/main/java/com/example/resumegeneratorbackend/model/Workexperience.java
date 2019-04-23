package com.example.resumegeneratorbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Workexperience")
public class Workexperience {


    @Id
    @GeneratedValue
    @Column(name = "id_workexperience")
    private Integer id_workExperience;

// observera att detta fält referar till user objectet
    @Column(name = "usersid")
    private Integer usersid;

    @Column(name = "title")
    private String title;
    @Column(name = "start_date")
    private String start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "end_date")
    private String end_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "description")
    private String description;

    public Integer getUsersid() {
        return usersid;
    }

    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getId_workExperience() {
        return id_workExperience;
    }

    public void setId_workExperience(Integer id_workExperience) {
        this.id_workExperience = id_workExperience;
    }
}
