package com.example.bigbowlxp;


import com.example.bigbowlxp.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ModelTest {

    @Test
    void bowlingModelTest() {
        BowlingLane lane = new BowlingLane();
        lane.setId(1);
        lane.setIsChildLane(false);
        lane.setStatus(true);
        lane.setDescription("all ok!");

        assertThat(lane.getId() == 1);
        assertThat(lane.isChildLane() == false);
        assertThat(lane.getStatus() == true);
        assertThat(lane.getDescription().equals("all ok!"));

        lane.setId(2);
        lane.setIsChildLane(true);
        lane.setStatus(false);
        lane.setDescription("it's ruined!");

        assertThat(lane.getId() == 2);
        assertThat(lane.isChildLane() == true);
        assertThat(lane.getStatus() == false);
        assertThat(lane.getDescription().equals("it's ruined!"));


    }

    @Test
    void airHockeyModelTest() {
        AirHockeyTable airHockeyTable = new AirHockeyTable();

        airHockeyTable.setAirhockeyTablesId(1);
        airHockeyTable.setStatus(true);
        airHockeyTable.setDescription("desc");

        assertThat(airHockeyTable.getAirhockeyTablesId() == 1);
        assertThat(airHockeyTable.getStatus() == true);
        assertThat(airHockeyTable.getDescription().equals("desc"));

    }


    @Test
    void customerModelTest() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Patrick");
        customer.setLastName("Kringelum");
        customer.setApartment("14");
        customer.setCity("Tórshavn");
        customer.setZipCode("100");
        customer.setStreetAddress("Sverrisgøta");
        customer.setFloor("25");
        customer.setApartment("Dør 14");
        customer.setPhone("00298421634");
        customer.setStreetNumber("5b");

        assertThat(customer.getCustomerId() == 1);
        assertThat(customer.getFirstName().equals("Patrick"));
        assertThat(customer.getLastName().equals("Kringelum"));
        assertThat(customer.getApartment().equals("14"));
        assertThat(customer.getCity().equals("Tórshavn"));
        assertThat(customer.getZipCode().equals("100"));
        assertThat(customer.getStreetAddress().equals("Sverrisgøta"));
        assertThat(customer.getFloor().equals("25"));
        assertThat(customer.getApartment().equals("Dør 14"));
        assertThat(customer.getPhone().equals("00298421634"));
        assertThat(customer.getStreetNumber().equals("5b"));
    }

   @Test
    void menuModelTest() {
        Menu menu = new Menu();
        menu.setFood_id(1);
        menu.setName("ost");
        menu.setPrice(1234.5);

        assertThat(menu.getFood_id() == 1);
        assertThat(menu.getName().equals("ost"));
        assertThat(menu.getPrice() == 1234.5);
    }

    @Test
    void equipmentModelTest() {
        Equipment equipment = new Equipment();
        equipment.setEquipment_id(1);
        equipment.setName("Sko");
        equipment.setType("størrelse 67");
        equipment.setAmount(6);

        assertThat(equipment.getEquipment_id() == 1);
        assertThat(equipment.getName().equals("Sko"));
        assertThat(equipment.getType().equals("størrelse 67"));
        assertThat(equipment.getAmount() == 6);

    }

    @Test
    void beverageTest(){
        Beverage beverage = new Beverage();
        beverage.setBeverageId(1);
        beverage.setName("Pisswasser");
        beverage.setPrice(40.0);

        assertThat(beverage.getBeverageId() == 1);
        assertThat(beverage.getName().equals("Pisswasser"));
        assertThat(beverage.getPrice() == 40.0);


    }

}
