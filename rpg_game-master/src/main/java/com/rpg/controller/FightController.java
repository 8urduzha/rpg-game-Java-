package com.rpg.controller;

import com.rpg.dto.HeroDto;
import com.rpg.dto.MonsterDto;
import com.rpg.entity.Hero;
import com.rpg.entity.Monster;
import com.rpg.service.HeroService;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FightController {

    @Autowired
    private HeroService heroService;
    @Autowired
    private MonsterService monsterService;

    @GetMapping("/fight/{heroId}/{monsterId}")
    public String getFightJsp(Model model,
                        @PathVariable(name = "heroId") Long heroId,
                        @PathVariable(name = "monsterId") Long monsterId){

        Hero hero = heroService.getOneWithClassBonus(heroId);
        Monster monster = monsterService.getOne(monsterId);

        model.addAttribute("hero" , new HeroDto(hero));
        model.addAttribute("monster" , new MonsterDto(monster));
        return "fight";
    }

    @PostMapping("/fight/{heroId}/{monsterId}")
    public String fight(Model model,
                        @RequestParam(name = "choose") int choose,
                        @PathVariable(name = "heroId") Long heroId,
                        @PathVariable(name = "monsterId") Long monsterId) {
        Hero hero = heroService.getOneWithClassBonus(heroId);
        Monster monster = monsterService.getOne(monsterId);
        if (choose == 1) {
            heroService.doStep(hero , monster);
        }
        model.addAttribute("hero" , new HeroDto(hero));
        model.addAttribute("monster" , new MonsterDto(monster));
        return "redirect:"+ monsterId;
    }



}
