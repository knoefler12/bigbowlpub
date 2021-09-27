package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.services.BowlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String bowlingStatusDesc(@PathVariable("id") int id, @ModelAttribute String description){
        bowlingService.bowlingStatusDesc(description, id);
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
