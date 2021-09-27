package com.example.bigbowlxp.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AirHockeyTable {

    @Id
    private int airhockeyTableId;
    private boolean status;
    private String description;


    public AirHockeyTable() {
    }

    public int getAirhockeyTableId() {
        return airhockeyTableId;
    }

    public void setAirhockeyTableId(int id) {
        this.airhockeyTableId = id;
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
