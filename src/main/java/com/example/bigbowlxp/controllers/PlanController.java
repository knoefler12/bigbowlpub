package com.example.bigbowlxp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PlanController {

    @GetMapping("/plan")
    public String getWorkPlan(){
        return "plan.html";
    }
}
