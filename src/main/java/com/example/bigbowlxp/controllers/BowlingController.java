package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.services.BowlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BowlingController {

    private BowlingService bowlingService;


    @GetMapping("/bowlinglanes")
    public String getLanes(Model model) {
        model.addAttribute("bowlingLanes", bowlingService.getLanes());
        return "bowling.html";
    }

    @Autowired
    public void setBowlingService(BowlingService bowlingService) {
        this.bowlingService = bowlingService;
    }

    public BowlingService getBowlingService() {
        return bowlingService;
    }
}
