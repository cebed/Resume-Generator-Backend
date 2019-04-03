package com.example.resumegeneratorbackend.model;

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
}
