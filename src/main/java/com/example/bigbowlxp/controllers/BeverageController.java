package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.Beverage;
import com.example.bigbowlxp.services.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BeverageController {

    private BeverageService beverageService;

    @GetMapping("/createBeverage")
    public String createBeverage() {
        return "createBeverage.html";
    }

    @PostMapping("/createBeverage")
    public String createBeverage(@ModelAttribute Beverage beverage) {
        beverageService.createBeverage(beverage);
        return "redirect:/mad";
    }

    @GetMapping("/deleteBeverage/{id}")
    public String deleteBeverage(@PathVariable int id) {
        beverageService.deleteBeverage(id);
        return "redirect:/mad";
    }

    @GetMapping("/beverage/{beverageId}")
    public String updateBeverage(@PathVariable int beverageId, Model model){
        model.addAttribute("beverage", beverageService.findBeverageById(beverageId));
        return "updateBeverage";
    }

    @PostMapping("/beverage/{id}")
    public String updateBeverage(@ModelAttribute Beverage beverage) {
        beverageService.updateBeverage(beverage);
        return "redirect:/mad";
    }

    public BeverageService getBeverageService() {
        return beverageService;
    }

    @Autowired
    public void setBeverageService(BeverageService beverageService) {
        this.beverageService = beverageService;
    }


}
