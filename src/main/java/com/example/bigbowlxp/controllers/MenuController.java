package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.Menu;
import com.example.bigbowlxp.services.BeverageService;
import com.example.bigbowlxp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {

    private MenuService menuService;

    private BeverageService beverageService;

    @GetMapping("/mad")
    public String showFood(Model foodModel){
        foodModel.addAttribute("Menu", menuService.fetchMenu());
        foodModel.addAttribute("beverages", beverageService.fetchBeverages());
        return "mad.html";
    }

    @PostMapping("/changePrice/{id}")
    public String changeFoodPrice(@PathVariable("id") int id, @ModelAttribute Menu menu){
        menuService.changeFoodPrice(menu, id);
        return "redirect:/mad";
    }

    public BeverageService getBeverageService() {
        return beverageService;
    }

    @Autowired
    public void setBeverageService(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public MenuService getMenuService() {
        return menuService;
        }
}
