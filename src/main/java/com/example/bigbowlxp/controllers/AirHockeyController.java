package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.services.AirHockeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
