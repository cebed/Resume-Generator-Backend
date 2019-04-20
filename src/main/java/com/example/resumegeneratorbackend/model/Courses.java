package com.example.resumegeneratorbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Courses {


    @Id
    @Getter
    @Setter
    @GeneratedValue
    @Column(name = "coursesId")
    private Integer coursesId;

    @Column(name = "title")
    private String title;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "start_date")
    private String start_date;
    // observera att detta fält referar till user objectet
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(Integer coursesId) {
        this.coursesId = coursesId;
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
}
