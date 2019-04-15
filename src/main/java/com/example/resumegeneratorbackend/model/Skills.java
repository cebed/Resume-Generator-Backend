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
    @Column(name = "id")
    private Integer id;
    @Getter
    @Setter
    @Column(name = "title")
    private String title;
    @Getter
    @Setter
    @Column(name = "level")
    private String level;

    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    @ManyToOne
    private  Users USER_ID;
}
