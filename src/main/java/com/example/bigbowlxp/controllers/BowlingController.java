package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.BowlingLane;
import com.example.bigbowlxp.services.BowlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BowlingController {

    private BowlingService bowlingService;


    @GetMapping("/bowlinglanes")
    public String getLanes(Model model) {
        model.addAttribute("bowlingLanes", bowlingService.getLanes());
        System.out.println(bowlingService.getLanes().get(0).isChildLane());
        return "bowling.html";
    }

    @GetMapping("/statusupdate/{id}")
    public String updatesBowlingStatus(@PathVariable("id") int id){
        bowlingService.bowlingLaneStatus(id);
        return "redirect:/bowlinglanes";
    }

    @PostMapping("/bowlingstatus/{id}")
    public String bowlingStatusDesc(@PathVariable("id") int id, @ModelAttribute BowlingLane bowlingLane) {
        bowlingService.bowlingStatusDesc(bowlingLane, id);
        return "redirect:/bowlinglanes";
    }



    @Autowired
    public void setBowlingService(BowlingService bowlingService) {
        this.bowlingService = bowlingService;
    }

    public BowlingService getBowlingService() {
        return bowlingService;
    }
}
