package com.example.bigbowlxp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.bigbowlxp.models.Menu;

import java.util.List;

@Repository
public class MenuRepo {

    private JdbcTemplate jdbcTemplate;

    public List<Menu> fetchMenu(){
        String sql = "SELECT * FROM sql4438617.food";
        RowMapper<Menu> menuRowMapper = new BeanPropertyRowMapper<>(Menu.class);
        return jdbcTemplate.query(sql, menuRowMapper);
    }

    public void changePrice(Menu menu, int id){
        String sql = "UPDATE food SET price = ? WHERE food_id = ?";
        double price = menu.getPrice();
        jdbcTemplate.update(sql, price, id);
    }

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
