package com.example.bigbowlxp.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AirHockeyTable {

    @Id
    private int airHockeyTablesId;
    private boolean status;
    private String description;


    public AirHockeyTable() {
    }

    public int getAirHockeyTablesId() {
        return airHockeyTablesId;
    }

    public void setAirHockeyTablesId(int id) {
        this.airHockeyTablesId = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
