package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    public List<Customer> fetchCustomer(){
        String sql = "SELECT * FROM sql4438617.customers";
        RowMapper<Customer> customerRowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.query(sql, customerRowMapper);
    }

}
