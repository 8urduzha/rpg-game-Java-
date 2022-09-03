package com.rpg.service.impl;

import com.rpg.dto.LocationDto;
import com.rpg.entity.Hero;
import com.rpg.entity.Location;
import com.rpg.entity.Monster;
import com.rpg.exception.location.LocationExistException;
import com.rpg.repository.LocationRepository;
import com.rpg.service.HeroService;
import com.rpg.service.LocationService;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {

    @Value("${file.path}")
    private String path;

    @Autowired
    private LocationRepository repository;

    @Autowired
    private MonsterService monsterService;
    @Autowired
    private HeroService heroService;



    @Override
    public Location save(Location location) {
        return repository.save(location);
    }

    @Override
    public Location getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Location getLocationByMonsterId(Long monsterId) {
//        Monster monster = monsterService.getOne(monsterId);
//        return monster.getLocation();
        return new Location();
    }

    @Override
    public List<LocationDto> getLocationForHero(Long heroId) {
        List<Location> all = getAll();
        Hero hero = heroService.getOne(heroId);
        List<LocationDto> locationDtos = getLocationDtos(all, hero);
        return locationDtos;
    }

    @Override
    public List<LocationDto> locationToDto(List<Location> locations) {
        List<LocationDto> locationDtos = new ArrayList<>();
        for (Location location : locations) {
            locationDtos.add(new LocationDto(location));
        }
        return locationDtos;
    }

    @Override
    public void addLocation(String name , MultipartFile file) {
        Location location = new Location(name);
        if (repository.countByName(name) > 0) throw new LocationExistException("Location with this name: "+name+" already exist");
        if(file!=null&&!file.isEmpty()) {
            String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String fileName = UUID.randomUUID().toString()+extention;
            try {
                file.transferTo(new File(path+fileName));
                location.setPhotoUrl(fileName);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        save(location);
    }

    @Override
    public void deleteMonster(Long monsterId , Long locationId) {
        Location location = getOne(locationId);
        Monster monster = monsterService.getOne(monsterId);
        monster.getLocation().remove(location);
        monsterService.save(monster);
    }

    @Override
    public void addMonster(Long monsterId, Long locationId) {
        Location location = getOne(locationId);
        Monster monster = monsterService.getOne(monsterId);
        List<Location> locations = monster.getLocation();
        locations.add(location);
        monsterService.save(monster);
    }

    private List<LocationDto> getLocationDtos(List<Location> all, Hero hero) {
        List<LocationDto> locationDtos = new ArrayList<>();
        for (Location location : all) {
            boolean passedByHero = location.getPassedBy().contains(hero);
            locationDtos.add(new LocationDto(location , passedByHero));
        }
        return locationDtos;
    }
}
