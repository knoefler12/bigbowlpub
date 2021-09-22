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

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Menu> fetchMenu(){
        String sql = "SELECT * FROM sql4438617.food";
        RowMapper<Menu> menuRowMapper = new BeanPropertyRowMapper<>(Menu.class);
        return jdbcTemplate.query(sql, menuRowMapper);
    }
}
