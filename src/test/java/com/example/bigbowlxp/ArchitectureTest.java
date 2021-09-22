package com.example.bigbowlxp;

import com.example.bigbowlxp.controllers.AirHockeyController;
import com.example.bigbowlxp.controllers.BowlingController;
import com.example.bigbowlxp.controllers.CustomerController;
import com.example.bigbowlxp.controllers.MenuController;
import com.example.bigbowlxp.models.AirHockey;
import com.example.bigbowlxp.repositories.AirHockeyRepo;
import com.example.bigbowlxp.repositories.BowlingRepo;
import com.example.bigbowlxp.repositories.CustomerRepo;
import com.example.bigbowlxp.repositories.MenuRepo;
import com.example.bigbowlxp.services.AirHockeyService;
import com.example.bigbowlxp.services.BowlingService;
import com.example.bigbowlxp.services.CustomerService;
import com.example.bigbowlxp.services.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ArchitectureTest {


    @Autowired
    private BowlingController bowlingController;

    @Autowired
    private AirHockeyController airHockeyController;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private MenuController menuController;


    @Test
    void bowlingArchitectureTest(){

        assertThat(bowlingController).isNotNull();
        BowlingService bowlingService = bowlingController.getBowlingService();

        assertNotNull(bowlingService);

        BowlingRepo bowlingRepo = bowlingService.getBowlingRepo();
        assertNotNull(bowlingRepo);

        JdbcTemplate template = bowlingRepo.getTemplate();
        assertNotNull(template);

    }

    @Test
    void airHockeyArchitectureTest(){
        assertNotNull(airHockeyController);

        AirHockeyService airHockeyService = airHockeyController.getAirHockeyService();
        assertNotNull(airHockeyService);

        AirHockeyRepo airHockeyRepo = airHockeyService.getAirHockeyRepo();
        assertNotNull(airHockeyRepo);

        JdbcTemplate template = airHockeyRepo.getTemplate();
        assertNotNull(template);

    }

    @Test
    void customerArchitectureTest(){
        assertNotNull(customerController);

        CustomerService customerService = customerController.getCustomerService();
        assertNotNull(customerService);

        CustomerRepo customerRepo = customerService.getCustomerRepo();
        assertNotNull(customerRepo);

        JdbcTemplate template = customerRepo.getTemplate();
        assertNotNull(template);

    }

    @Test
    void menuArchitectureTest(){
        assertNotNull(menuController);

        MenuService menuService = menuController.getMenuService();
        assertNotNull(menuService);

        MenuRepo menuRepo = menuService.getMenuRepo();
        assertNotNull(menuRepo);

        JdbcTemplate template = menuRepo.getTemplate();
        assertNotNull(template);
    }


}
