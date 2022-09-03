package com.rpg.controller;


import com.google.gson.Gson;
import com.rpg.entity.Monster;
import com.rpg.dto.MonsterDto;
import com.rpg.repository.MonsterRepository;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MonsterController {


    @Autowired
    private MonsterService monsterService;
    @Autowired
    private MonsterRepository repository;

    @GetMapping("getMonster/{id}")
    @ResponseBody
    public String getOne(@PathVariable(name = "id") Long id){
        Gson gson = new Gson();
        List<Monster> byLocationId = repository.findByLocationId(id);
        List<MonsterDto>monstersDto = new ArrayList<>();
        for (Monster monster:byLocationId) {
            monstersDto.add(new MonsterDto(monster));
        }
        return gson.toJson(gson.toJson(monstersDto));
    }

}
