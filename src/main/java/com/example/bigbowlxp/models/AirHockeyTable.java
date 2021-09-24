package com.example.bigbowlxp.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AirHockeyTable {

    @Id
    private int id;
    private boolean status;
    private String description;


    public AirHockeyTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void setDescription(String desc) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
