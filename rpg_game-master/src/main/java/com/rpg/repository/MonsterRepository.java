package com.rpg.repository;

import com.rpg.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MonsterRepository extends JpaRepository<Monster , Long> {

    List<Monster> findByLocationId(Long id);

}
