package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.AirHockeyTable;
import com.example.bigbowlxp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirHockeyRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    public List<AirHockeyTable> fetchAirHockey(){
        String sql = "SELECT * FROM sql4438617.airhockey_tables";
        RowMapper<AirHockeyTable> airHockeyTableRowMapper = new BeanPropertyRowMapper<>(AirHockeyTable.class);
        return jdbcTemplate.query(sql, airHockeyTableRowMapper);
    }
}
