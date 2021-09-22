package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.services.BowlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BowlingController {

    private BowlingService bowlingService;

    @Autowired
    public void setBowlingService(BowlingService bowlingService) {
        this.bowlingService = bowlingService;
    }

    public BowlingService getBowlingService() {
        return bowlingService;
    }
}
