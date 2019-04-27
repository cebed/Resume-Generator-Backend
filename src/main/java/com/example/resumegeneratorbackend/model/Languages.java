package com.example.resumegeneratorbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Languages")
public class Languages {

    @Id
    @GeneratedValue
    @Column(name = "id_language")
    private Integer id_language;

    @Column(name = "id")
    private Integer id;
    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @Column(name="level")
    private String level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Users users;

    private String owner;


    public Integer getId_language() {
        return id_language;
    }

    public void setId_language(Integer id_language) {
        this.id_language = id_language;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
