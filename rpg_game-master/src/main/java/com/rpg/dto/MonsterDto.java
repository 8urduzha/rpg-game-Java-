package com.rpg.dto;

import com.rpg.entity.Monster;
import lombok.Data;

@Data
public class MonsterDto {

    private Long id;

    private String name;

    private Integer hitPoint;

    private Integer manaPoint;

    private Integer power;

    private Integer currHP;

    private Integer currMP;

    public MonsterDto(Monster monster) {
        this.id = monster.getId();
        this.manaPoint = monster.getManaPoint();
        this.name = monster.getName();
        this.hitPoint = monster.getHitPoint();
        this.power = monster.getPower();
        this.currHP = monster.getCurrHP();
        this.currMP = monster.getCurrMP();
    }

    public MonsterDto() {
    }
}
