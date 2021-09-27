package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.AirHockeyTable;
import com.example.bigbowlxp.models.Customer;
import com.example.bigbowlxp.models.Equipment;
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

    public void updateAirHockey(AirHockeyTable a){
        String sql = "UPDATE airhockey_tables SET status = ?, descripton = ? WHERE airhockey_tables_id = ?";
        jdbcTemplate.update(sql,a.getStatus(),a.getDescription(),a.getAirHockeyTablesId());

    }
    public AirHockeyTable findEquipmentById(int airhockey_id){
        String sql = "SELECT * FROM airhockey_tables WHERE airhockey_tables_id = ?";
        RowMapper<AirHockeyTable> rowMapper = new BeanPropertyRowMapper<>(AirHockeyTable.class);
        AirHockeyTable e = jdbcTemplate.queryForObject(sql, rowMapper, airhockey_id);
        return e;
    }
}
