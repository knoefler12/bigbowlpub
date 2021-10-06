package com.example.bigbowlxp.models;

public class BookingBeverage {

    private int bookingId;
    private int beverageId;
    private String name;
    private double price;
    private int amount;

    public BookingBeverage() {
    }

    public BookingBeverage(int bookingId, int beverageId, String name, double price, int amount) {
        this.bookingId = bookingId;
        this.beverageId = beverageId;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
