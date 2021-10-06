package com.example.bigbowlxp.models;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking {

    @Id
    private int bookingId;
    private int customer_id;
    private String firstName;
    private String lastName;
    private String phone;
    private Activity activity;
    private String date;
    private String startTime;
    private int duration;
    private List<BookingBeverage> beverages;



    public Booking (){
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customerId) {
        this.customer_id = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<BookingBeverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<BookingBeverage> beverages) {
        this.beverages = beverages;
    }
}
