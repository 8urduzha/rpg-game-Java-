package com.rpg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class HeroClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer bonusHp;

    private Integer bonusMp;


    @OneToMany(mappedBy = "heroClass" , cascade = CascadeType.ALL)
    private List<Hero> heroes;


    @Override
    public String toString() {
        return "HeroClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bonusHp=" + bonusHp +
                ", bonusMp=" + bonusMp +
                '}';
    }
}
