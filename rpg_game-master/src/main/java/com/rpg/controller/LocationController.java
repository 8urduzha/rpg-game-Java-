package com.rpg.controller;

import com.google.gson.Gson;
import com.rpg.entity.Location;
import com.rpg.dto.LocationDto;
import com.rpg.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/getLocation/{id}")
    @ResponseBody
    public String getLocation(@PathVariable(name = "id") Long id){
        Gson gson = new Gson();
        return gson.toJson(new LocationDto(locationService.getOne(id)));
    }

    @GetMapping("/saveNewRandomLocation")
    @ResponseBody
    public String saveLocation(){
        Gson gson = new Gson();
        Location location = new Location();
        location.setName("Blablabla");
        return gson.toJson(new LocationDto(locationService.save(location)));
    }

    @GetMapping("/GetLocationByMosterId/{id}")
    @ResponseBody
    public String getLocationByMonster(@PathVariable(name = "id") Long id){
        return new Gson().toJson(new LocationDto( locationService.getLocationByMonsterId(id)));
    }

    @PostMapping("/getLocationByHeroId")
    public String getLocationByHeroId (@RequestParam(name = "heroId") Long heroId , Model model){
        model.addAttribute("locations" , locationService.getLocationForHero(heroId));
        return "locationChoose";
    }


}
