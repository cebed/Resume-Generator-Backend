package com.example.resumegeneratorbackend.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Skills")
public class Skills {



    @Id
    @Getter
    @Setter
    @GeneratedValue
    @Column(name = "skills_Id")
    private Integer skills_Id;



    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "level")
    private String level;


    public Integer getSkills_Id() {
        return skills_Id;
    }

    public void setSkills_Id(Integer skills_Id) {
        this.skills_Id = skills_Id;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
