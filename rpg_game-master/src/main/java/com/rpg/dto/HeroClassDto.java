package com.rpg.dto;

import com.rpg.entity.HeroClass;
import lombok.Data;

@Data
public class HeroClassDto {

    private Long id;

    private String name;

    private Integer bonusHp;

    private Integer bonusMp;

    public HeroClassDto(HeroClass heroClass) {
        this.id = heroClass.getId();
        this.name = heroClass.getName();
        this.bonusHp = heroClass.getBonusHp();
        this.bonusMp = heroClass.getBonusMp();
    }
}
