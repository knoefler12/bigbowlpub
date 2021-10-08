package com.example.bigbowlxp;

import com.example.bigbowlxp.controllers.BeverageController;
import com.example.bigbowlxp.models.Beverage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.criteria.CriteriaBuilder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


@SpringBootTest
public class BeverageTest {

    @Autowired
    BeverageController beverageController;

    @Autowired
    JdbcTemplate template;


    @Test
    void CRUDTest() {
        Beverage beverage = new Beverage();
        beverage.setName("testnamethatisnevergoingtobeused");
        beverage.setPrice(0.5);

        String sql = "SELECT * FROM beverages WHERE name='testnamethatisnevergoingtobeused'";

        Beverage dbBeverage;

        try {
            dbBeverage = template.queryForObject(sql, Beverage.class);
            fail();
        } catch (Exception e) {
        }

        beverageController.getBeverageService().createBeverage(beverage);

        dbBeverage = template.query(sql, new BeanPropertyRowMapper<>(Beverage.class)).get(0);

        assertThat(beverage.getName().equals(dbBeverage.getName()));
        assertThat(beverage.getPrice() == dbBeverage.getPrice());

        beverage.setPrice(123456.3);
        beverageController.getBeverageService().updatePrice(123456.3, dbBeverage.getBeverageId());

        dbBeverage = template.query(sql, new BeanPropertyRowMapper<>(Beverage.class)).get(0);

        assertThat(beverage.getPrice() == dbBeverage.getPrice());
        assertThat(beverage.getName().equals(dbBeverage.getName()));

        template.update("DELETE FROM beverages WHERE name = 'testnamethatisnevergoingtobeused'");


    }


}
