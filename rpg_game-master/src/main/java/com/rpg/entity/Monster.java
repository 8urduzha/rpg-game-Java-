package com.rpg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer hitPoint;

    @Column(nullable = false)
    private Integer manaPoint;

    @Column(nullable = false)
    private Integer power;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Location> location;

    private Integer currHP;

    private Integer currMP;


    public Monster() {
    }

    @PrePersist
    public void onCreate(){

        this.currHP = hitPoint;
        this.currMP = manaPoint;

    }


    public Monster(String name, Integer hitPoint, Integer manaPoint, Integer power) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.manaPoint = manaPoint;
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(id, monster.id) &&
                Objects.equals(name, monster.name) &&
                Objects.equals(hitPoint, monster.hitPoint) &&
                Objects.equals(manaPoint, monster.manaPoint) &&
                Objects.equals(power, monster.power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hitPoint, manaPoint, power);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(Integer hitPoint) {
        this.hitPoint = hitPoint;
    }

    public Integer getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(Integer manaPoint) {
        this.manaPoint = manaPoint;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public Integer getCurrHP() {
        return currHP;
    }

    public void setCurrHP(Integer currHP) {
        this.currHP = currHP;
    }

    public Integer getCurrMP() {
        return currMP;
    }

    public void setCurrMP(Integer currMP) {
        this.currMP = currMP;
    }
}
