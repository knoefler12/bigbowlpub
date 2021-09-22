package com.example.bigbowlxp.services;

import com.example.bigbowlxp.repositories.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private MenuRepo menuRepo;

    @Autowired
    public void setMenuRepo(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

}
