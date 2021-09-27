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


    @GetMapping("/airhockeytables/{airhockeyTableId}")
    public String updatesBowlingStatus(@PathVariable("airhockeyTableId") int airhockeyTableId){
        airHockeyService.airhockeyTableStatus(airhockeyTableId);
        return "redirect:/airhockeytables";
    }

    @PostMapping("/airhockeytables/{airhockeyTableId}")
    public String bowlingStatusDesc(@PathVariable("airhockeyTableId") int airhockeyTableId, @ModelAttribute String description){
        airHockeyService.airhockeyDescription(description, airhockeyTableId);
        return "hockey.html";
    }
}
