package com.rpg.service.impl;

import com.rpg.dto.MonsterDto;
import com.rpg.entity.Monster;
import com.rpg.repository.MonsterRepository;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRepository repository;

    @Override
    public Monster save(Monster monster) {
        return repository.save(monster);
    }

    @Override
    public Monster getOne(Long id) {
        return repository.getOne(id);
}

    @Override
    public List<MonsterDto> getAllDto() {
        List<Monster> monsters = repository.findAll();
        return monstersToMonstersDto(monsters);
    }

    private List<MonsterDto> monstersToMonstersDto(List<Monster> monsters) {
        List<MonsterDto> dtos = new ArrayList<>();
        if (monsters == null) return Collections.emptyList();
        for (Monster monster:monsters) {
            dtos.add(new MonsterDto(monster));
        }
        return dtos;
    }
}
