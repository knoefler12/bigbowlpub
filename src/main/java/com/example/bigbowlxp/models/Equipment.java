package com.example.bigbowlxp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipment {

    @Id
    private int equipment_id;
    private String name;
    private String type;
    private int amount;

    public Equipment(){
    }

    public Equipment(int equipment_id, String name, String type, int amount) {
        this.equipment_id = equipment_id;
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
