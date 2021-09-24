package com.example.bigbowlxp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AirHockeyTable {

    @Id
    private int id;
    private String status;


    public AirHockeyTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
