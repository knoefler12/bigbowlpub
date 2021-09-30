package com.example.bigbowlxp.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AirHockeyTable {

    @Id
    private int airhockeyTablesId;
    private boolean status;
    private String description;

    public AirHockeyTable() {
    }

    public int getAirhockeyTablesId() {
        return airhockeyTablesId;
    }

    public void setAirhockeyTablesId(int id) {
        this.airhockeyTablesId = id;
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
