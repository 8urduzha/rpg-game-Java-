package com.rpg.dto;

import com.rpg.entity.Location;
import com.rpg.entity.Monster;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LocationDto {

    private Long id;

    private String name;

    private boolean passedByHero;

    private String photoUrl;

    private List<MonsterDto> monsters = new ArrayList<>();

    public LocationDto(Location location , boolean passedByHero) {
        this.id = location.getId();
        this.name = location.getName();
        this.photoUrl = location.getPhotoUrl();
        this.passedByHero = passedByHero;
        if (location.getMonsters() != null){
            for (Monster monster : location.getMonsters()) {
                this.monsters.add(new MonsterDto(monster));
            }
        }
    }


    public LocationDto(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.photoUrl = location.getPhotoUrl();
        if (location.getMonsters() != null){
            for (Monster monster : location.getMonsters()) {
                this.monsters.add(new MonsterDto(monster));
            }
        }
    }


}
