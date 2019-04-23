package com.example.resumegeneratorbackend.model;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Table(name = "others")
public class Others {

    @Id
    @Getter
    @Setter
    @GeneratedValue
    @Column(name = "others_Id")
    private Integer others_Id;

    @Column(name = "users_id")
    private Integer users_id;


    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;



    public Integer getOthers_Id() {
        return others_Id;
    }

    public void setOthers_Id(Integer others_Id) {
        this.others_Id = others_Id;
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

    public Integer getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
    }
}

