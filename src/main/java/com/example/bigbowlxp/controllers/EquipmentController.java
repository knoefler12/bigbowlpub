package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.Equipment;
import com.example.bigbowlxp.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EquipmentController {

    private EquipmentService equipmentService;

    @Autowired
    public void setEquipmentService(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }
    public EquipmentService getEquipmentService(){
        return equipmentService;
    }

    @GetMapping("/equipment")
    public String getAllEquipment(Model model){
        List<Equipment> equipmentList = equipmentService.fetchAllEquipment();
        model.addAttribute("equipment", equipmentList);
        return "equipment";
    }

    @GetMapping("/equipment/{equipment_id}")
    public String updateEquipment(@PathVariable int equipment_id, Model model){
        model.addAttribute("equipment", equipmentService.findEquipmentById(equipment_id));
        return "updateEquipment";
    }

    @PatchMapping("equipment/{equipment_id}")
    public String updateEquipment(@ModelAttribute Equipment equipment){
        equipmentService.updateEquipment(equipment);
        return "equipment";
    }

}
