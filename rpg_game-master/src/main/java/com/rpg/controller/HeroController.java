package com.rpg.controller;

import com.google.gson.Gson;
import com.rpg.dto.HeroDto;
import com.rpg.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeroController {

    @Autowired
    private HeroService heroService;

    @PostMapping("/getOneHero")
    @ResponseBody
    public String getOne(@RequestParam(name = "heroId") Long id){
        Gson gson = new Gson();
        return gson.toJson(new HeroDto(heroService.getOneWithClassBonus(id)));

    }

    @GetMapping("{userId}/getAllHeroes")
    public String getAllHeroes(@PathVariable(name = "userId") Long userId, Model model){
        model.addAttribute("heroes" , heroService.getAllByUserId(userId));
        return "heroChoose";
    }


}
