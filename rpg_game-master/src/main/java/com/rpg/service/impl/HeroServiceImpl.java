package com.rpg.service.impl;

import com.rpg.entity.Hero;
import com.rpg.entity.HeroClass;
import com.rpg.entity.Monster;
import com.rpg.exception.HeroDeadException;
import com.rpg.repository.HeroRepository;
import com.rpg.service.HeroService;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository repository;

    @Autowired
    private MonsterService monsterService;


    @Override
    public Hero save(Hero hero) {
        return repository.save(hero);
    }

    @Override
    public Hero getOneWithClassBonus(Long id) {
        Hero hero = repository.getOne(id);
        addToHeroHimClassBonus(hero);
        return hero;
    }

    @Override
    public List<Hero> getAll() {
        return repository.findAll();
    }

    @Override
    public Hero getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public Hero fight(Hero hero, Monster monster) {
        while (monster.getHitPoint() > 0){
            doStep(hero , monster);
            if (hero.getHitPoint() <= 0)throw new HeroDeadException("HAhaha i kill you" , monster);
        }
        System.out.println("Monster dead");
        return hero;
    }

    public void doStep (Hero hero , Monster monster){
        Integer heroPower = hero.getPower();
        Integer monsterPower = monster.getPower();
        monster.setHitPoint(monster.getHitPoint() - heroPower);
        if (monster.getHitPoint() > 0){
            hero.setHitPoint(hero.getHitPoint() - monsterPower);
        }
        save(hero);
        monsterService.save(monster);

    }

    @Override
    public List<Hero> getAllByUserId(Long userId) {
        return repository.getAllByUserId(userId);
    }

    private void addToHeroHimClassBonus(Hero hero){
        HeroClass heroClass = hero.getHeroClass();
        hero.setHitPoint(hero.getHitPoint() + heroClass.getBonusHp());
        hero.setManaPoint(hero.getManaPoint() + heroClass.getBonusMp());
    }


}
