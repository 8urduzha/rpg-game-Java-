package com.rpg.controller;

import com.rpg.dto.LocationDto;
import com.rpg.dto.MonsterDto;
import com.rpg.service.LocationService;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LocationAdministrationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private MonsterService monsterService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/location")
    public String locationAdministration(Model model){
        model.addAttribute("locations" , locationService.locationToDto(locationService.getAll()));
        return "locationAdministration";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addLocation")
    public String addLocation(@RequestParam(name = "locationName") String name , @RequestParam(name = "image") MultipartFile file ,  Model model){
        locationService.addLocation(name , file);
        return "redirect:/admin/location";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/location/delete/{locationId}")
    public String deleteLocation(@PathVariable(name = "locationId") Long id){
        locationService.delete(id);
        return "redirect:/admin/location";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/location/{locationId}")
    public String getLocationInfo(@PathVariable(name = "locationId") Long locationId , Model model){
        model.addAttribute("location" ,new LocationDto(locationService.getOne(locationId)));
        model.addAttribute("monsters" , monsterService.getAllDto());
        return "locationInfo";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/location/{locationId}/delete/monster/{monsterId}")
    public String deleteMonsterFromLocation(@PathVariable(name = "monsterId") Long monsterId , @PathVariable(name = "locationId") Long locationId){
        locationService.deleteMonster(monsterId , locationId);
        return "redirect:/admin/location/"+locationId;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/location/{locationId}/add/monster/{monsterId}")
    public String addMonsterFromLocation(@PathVariable(name = "monsterId") Long monsterId , @PathVariable(name = "locationId") Long locationId){
        locationService.addMonster(monsterId , locationId);
        return "redirect:/admin/location/"+locationId;
    }




}
