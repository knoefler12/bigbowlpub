package com.example.bigbowlxp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bowling {

    @Id
    private int id;
    private String status;
    private boolean isChildLane;


    public Bowling() {
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

    public boolean isChildLane() {
        return isChildLane;
    }

    public void setChildLane(boolean childLane) {
        isChildLane = childLane;
    }
}
