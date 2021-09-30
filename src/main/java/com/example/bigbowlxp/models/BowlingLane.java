package com.example.bigbowlxp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BowlingLane {

    @Id
    private int id;
    private boolean status;
    private boolean isChildLane;
    private String description;
    private boolean booked;

    public BowlingLane() {
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

    public boolean isChildLane() {
        return isChildLane;
    }

    public void setIsChildLane(boolean childLane) {
        isChildLane = childLane;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
