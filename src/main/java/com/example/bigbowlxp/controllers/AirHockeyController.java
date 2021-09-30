package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.AirHockeyTable;
import com.example.bigbowlxp.models.Equipment;
import com.example.bigbowlxp.services.AirHockeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AirHockeyController {

    private AirHockeyService airHockeyService;



    @Autowired
    public void setAirHockeyService(AirHockeyService airHockeyService) {
        this.airHockeyService = airHockeyService;

    }

    public AirHockeyService getAirHockeyService() {
        return airHockeyService;
    }

    @GetMapping("/airhockeytables")
    public String fetchAirHockeyTables(Model model){
        model.addAttribute("airhockeytables", airHockeyService.fetchAirHockeyTable());
        return "hockey.html";
    }


    @GetMapping("/updateAirStatus/{id}")
    public String updatesAirHockeyTables(@PathVariable("id") int id){
        System.out.println(id);
        airHockeyService.airhockeyTableStatus(id);
        return "redirect:/airhockeytables";
    }

    @PostMapping("/airStatusDesc/{airhockeyTableId}")
    public String bowlingStatusDesc(@PathVariable("airhockeyTableId") int airhockeyTableId, @ModelAttribute String description){
        airHockeyService.airhockeyDescription(description, airhockeyTableId);
        return "hockey.html";
    }
}
