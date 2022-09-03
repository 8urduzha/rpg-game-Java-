package com.rpg.service;

import com.rpg.dto.MonsterDto;
import com.rpg.entity.Monster;

import java.util.List;

public interface MonsterService {

    Monster save(Monster monster);

    Monster getOne(Long id);

    List<MonsterDto> getAllDto();
}
