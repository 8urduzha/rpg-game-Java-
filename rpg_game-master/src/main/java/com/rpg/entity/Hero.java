package com.rpg.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@ToString
@Data
@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String name;

    @Column(name = "HP")
    private Integer hitPoint;

    @Column(name = "MP")
    private Integer manaPoint;

    @Column(name = "power")
    private Integer power;

    @ManyToOne
    private HeroClass heroClass;

    private Integer currHP;

    private Integer currMP;

    @ManyToMany(mappedBy = "passedBy")
    private List<Location> passedLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_Id" , nullable = false)
    private User user;

    @PrePersist
    public void onCreate(){

        this.currHP = hitPoint;
        this.currMP = manaPoint;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(id, hero.id) &&
                Objects.equals(name, hero.name) &&
                Objects.equals(hitPoint, hero.hitPoint) &&
                Objects.equals(manaPoint, hero.manaPoint) &&
                Objects.equals(power, hero.power) &&
                Objects.equals(currHP, hero.currHP) &&
                Objects.equals(currMP, hero.currMP) &&
                Objects.equals(user, hero.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hitPoint, manaPoint, power, currHP, currMP, user);
    }
}
