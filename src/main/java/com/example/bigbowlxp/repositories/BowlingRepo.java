package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.BowlingLane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BowlingRepo {

    private JdbcTemplate jdbcTemplate;

    public List<BowlingLane> fetchAllBowlingLanes() {
        String sql = "SELECT bowling_alley_id AS id, children_alley AS isChildLane, status" +
                ", description FROM bowling_alleys";
        RowMapper<BowlingLane> rowMapper = new BeanPropertyRowMapper<>(BowlingLane.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
