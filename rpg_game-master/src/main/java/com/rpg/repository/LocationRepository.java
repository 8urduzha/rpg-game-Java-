package com.rpg.repository;

import com.rpg.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location , Long> {

//    Location findByMonstersId(Monster monster);

    Integer countByName(String name);

}
