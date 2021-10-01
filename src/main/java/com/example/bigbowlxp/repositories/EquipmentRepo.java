package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    public List<Equipment> fetchAllEquipment(){
        String sql = "SELECT * FROM sql4438617.equipment ORDER BY name, type";
        RowMapper<Equipment> equipmentRowMapper = new BeanPropertyRowMapper<>(Equipment.class);
        return jdbcTemplate.query(sql, equipmentRowMapper);
    }

    public Equipment findEquipmentById(int equipment_id){
        String sql = "SELECT * FROM equipment WHERE equipment_id = ?";
        RowMapper<Equipment> rowMapper = new BeanPropertyRowMapper<>(Equipment.class);
        Equipment e = jdbcTemplate.queryForObject(sql, rowMapper, equipment_id);
        return e;
    }

    public void updateEquipment(Equipment e){
        String sql = "UPDATE equipment SET name = ?, type = ?, amount = ? WHERE equipment_id = ?";
        jdbcTemplate.update(sql, e.getName(), e.getType(), e.getAmount(), e.getEquipment_id());

    }

    public void deleteEquipment(int equipment_id){
        String sql = "DELETE FROM equipment WHERE equipment_id = ?";
        jdbcTemplate.update(sql, equipment_id);
    }

    public void addEquipment(Equipment e){
        String sql = "INSERT INTO equipment (name, type, amount) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, e.getName(), e.getType(), e.getAmount());
    }



}
