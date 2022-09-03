package com.rpg.service;

import com.rpg.dto.LocationDto;
import com.rpg.entity.Location;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LocationService {

    Location save (Location location);

    Location getOne(Long id);

    List<Location> getAll();

    void delete(Long id);

    Location getLocationByMonsterId(Long monsterId);

    List<LocationDto> getLocationForHero(Long heroId);

    List<LocationDto> locationToDto(List <Location> locations);

    void addLocation(String name , MultipartFile file);


    void deleteMonster(Long monsterId ,  Long locationId);

    void addMonster(Long monsterId ,  Long locationId);
}
