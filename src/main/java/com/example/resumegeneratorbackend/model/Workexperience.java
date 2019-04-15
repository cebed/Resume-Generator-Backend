package com.example.resumegeneratorbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Workexperience")
public class Workexperience {


    @Id
    @Getter
    @Setter
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Getter
    @Setter
    @Column(name = "title")
    private String title;
    @Getter
    @Setter
    @Column(name = "start_date")
    private String start_date;
    @Getter
    @Setter
    @Column(name = "end_date")
    private String end_date;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @JoinColumn(name = "USERS_id", referencedColumnName = "id")
    @ManyToOne
    private  Users courses_id;

    public Users getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(Users courses_id) {
        this.courses_id = courses_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
