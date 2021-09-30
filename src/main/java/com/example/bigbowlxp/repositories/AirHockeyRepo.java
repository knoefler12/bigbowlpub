package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.AirHockeyTable;
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
        jdbcTemplate.update(sql,a.getStatus(),a.getDescription(),a.getAirhockeyTablesId());

    }
    public AirHockeyTable findEquipmentById(int airhockey_id){
        String sql = "SELECT * FROM airhockey_tables WHERE airhockey_tables_id = ?";
        RowMapper<AirHockeyTable> rowMapper = new BeanPropertyRowMapper<>(AirHockeyTable.class);
        AirHockeyTable e = jdbcTemplate.queryForObject(sql, rowMapper, airhockey_id);
        return e;
    }

    public AirHockeyTable findAirhockeyTableById(int airhockeyTableId){
        String sql = "SELECT * FROM airhockey_tables WHERE airhockey_tables_id = ?";
        RowMapper<AirHockeyTable> rowMapper = new BeanPropertyRowMapper<>(AirHockeyTable.class);
        AirHockeyTable airHockeyTable = jdbcTemplate.queryForObject(sql, rowMapper, airhockeyTableId);
        return airHockeyTable;
    }

    public Boolean airhockeyTableStatus(int id){
        String sql = "UPDATE airhockey_tables SET status = NOT status WHERE airhockey_tables_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public void airhockeyDescription(AirHockeyTable airHockeyTable, int id){
        String sql = "UPDATE airhockey_tables SET description = ? WHERE airhockey_tables_id = ?";
        String description = airHockeyTable.getDescription();
        jdbcTemplate.update(sql, description, id);
    }
}
