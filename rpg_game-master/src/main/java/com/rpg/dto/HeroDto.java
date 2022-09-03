package com.rpg.dto;

import com.rpg.entity.Hero;
import lombok.Data;


@Data
public class HeroDto {

    private Long id;

    private String name;

    private Integer hitPoint;

    private Integer manaPoint;

    private Integer power;

    private HeroClassDto heroClass;

    private Integer currHP;

    private Integer currMP;


    public HeroDto(Hero hero) {
        this.id = hero.getId();
        this.name = hero.getName();
        this.hitPoint = hero.getHitPoint();
        this.manaPoint = hero.getManaPoint();
        this.power = hero.getPower();
        this.heroClass = new HeroClassDto(hero.getHeroClass());
        this.currHP = hero.getCurrHP();
        this.currMP = hero.getCurrMP();
    }
}
