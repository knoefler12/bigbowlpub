package com.example.bigbowlxp.models;


import javax.persistence.Id;

public class Beverage {


    @Id
    private int beverageId;
    private String name;
    private double price;

    public Beverage() {
    }

    public Beverage(int beverageId, String name, double price) {
        this.beverageId = beverageId;
        this.name = name;
        this.price = price;
    }

    public int getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(int beverageId) {
        this.beverageId = beverageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
