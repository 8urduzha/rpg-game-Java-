package com.rpg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "location")
    private List<Monster> monsters;

    @ManyToMany
    private List<Hero> passedBy;

    private String photoUrl;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }
}
