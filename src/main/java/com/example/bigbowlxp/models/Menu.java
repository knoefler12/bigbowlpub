package com.example.bigbowlxp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {

    @Id
    /* Variabler*/
    private int food_id;
    private String day;
    private String name;
    private double price;

    /*Konstruktør*/
    public Menu(){
    }


    /* Getter og settere*/
    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
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

    public String getDay(){return day;}

    public void setDay(String day){this.day = day;}

    }
