package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.Beverage;
import com.example.bigbowlxp.services.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @PostMapping("/updatePrice/{id}")
    public String updateBeverage(@PathVariable int id, @RequestParam int price) {
        beverageService.updatePrice(price, id);
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
