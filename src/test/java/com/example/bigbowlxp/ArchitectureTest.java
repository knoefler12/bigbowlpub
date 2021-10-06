package com.example.bigbowlxp;

import com.example.bigbowlxp.controllers.*;
import com.example.bigbowlxp.repositories.*;
import com.example.bigbowlxp.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EquipmentController equipmentController;

    @Autowired
    private BookingController bookingController;

    @Autowired
    private BeverageController beverageController;


    @Test
    void bowlingArchitectureTest() {

        assertThat(bowlingController).isNotNull();
        BowlingService bowlingService = bowlingController.getBowlingService();

        assertNotNull(bowlingService);

        BowlingRepo bowlingRepo = bowlingService.getBowlingRepo();
        assertNotNull(bowlingRepo);

        JdbcTemplate template = bowlingRepo.getTemplate();
        assertNotNull(template);

    }

    @Test
    void airHockeyArchitectureTest() {
        assertNotNull(airHockeyController);

        AirHockeyService airHockeyService = airHockeyController.getAirHockeyService();
        assertNotNull(airHockeyService);

        AirHockeyRepo airHockeyRepo = airHockeyService.getAirHockeyRepo();
        assertNotNull(airHockeyRepo);

        JdbcTemplate template = airHockeyRepo.getTemplate();
        assertNotNull(template);

    }

    @Test
    void customerArchitectureTest() {
        assertNotNull(customerController);

        CustomerService customerService = customerController.getCustomerService();
        assertNotNull(customerService);

        CustomerRepo customerRepo = customerService.getCustomerRepo();
        assertNotNull(customerRepo);

        JdbcTemplate template = customerRepo.getTemplate();
        assertNotNull(template);

    }

    @Test
    void menuArchitectureTest() {
        assertNotNull(menuController);

        MenuService menuService = menuController.getMenuService();
        assertNotNull(menuService);

        BeverageService beverageService = menuController.getBeverageService();
        assertNotNull(beverageService);

        MenuRepo menuRepo = menuService.getMenuRepo();
        assertNotNull(menuRepo);

        JdbcTemplate template = menuRepo.getTemplate();
        assertNotNull(template);
    }

    @Test
    void equipmentArchitectureTest() {
        assertNotNull(equipmentController);

        EquipmentService equipmentService = equipmentController.getEquipmentService();
        assertNotNull(equipmentService);

        EquipmentRepo equipmentRepo = equipmentService.getEquipmentRepo();
        assertNotNull(equipmentRepo);

        JdbcTemplate template = equipmentRepo.getTemplate();
        assertNotNull(template);
    }

    @Test
    void bookingArchitectureTest(){
        assertNotNull(bookingController);

        BookingService bookingService = bookingController.getBookingService();
        assertNotNull(bookingService);

        BookingRepo bookingRepo = bookingService.getBookingRepo();
        assertNotNull(bookingRepo);

        JdbcTemplate template = bookingRepo.getTemplate();
        assertNotNull(template);
    }

    @Test
    void beverageArchitectureTest(){
        assertNotNull(beverageController);

        BeverageService beverageService = beverageController.getBeverageService();
        assertNotNull(beverageService);

        BeverageRepo beverageRepo = beverageService.getBeverageRepo();
        assertNotNull(beverageRepo);

        JdbcTemplate template = beverageRepo.getTemplate();
        assertNotNull(template);
    }
}