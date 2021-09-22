package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.services.AirHockeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AirHockeyController {

    private AirHockeyService airHockeyService;



    @Autowired
    public void setAirHockeyService(AirHockeyService airHockeyService) {
        this.airHockeyService = airHockeyService;

    }

}
