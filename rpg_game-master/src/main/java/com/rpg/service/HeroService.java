package com.rpg.service;

import com.rpg.entity.Hero;
import com.rpg.entity.Monster;

import java.util.List;

public interface HeroService {

    Hero save (Hero hero);

    Hero getOneWithClassBonus(Long id);

    List<Hero> getAll();

    Hero getOne(Long id);

    Hero fight(Hero hero , Monster monster);

    void doStep (Hero hero , Monster monster);

    List<Hero> getAllByUserId(Long userId);


}
