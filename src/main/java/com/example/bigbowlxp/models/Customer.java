package com.example.bigbowlxp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private int customerid;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String eMail;
    private String street;
    private String streetNumber;
    private String floor;
    private String thtv;
    private String zipCode;

    public Customer() {
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int id) {
        this.customerid = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }


    public String getFloor() {
        return floor;
    }

    public void setFloor(String apartment) {
        this.floor = apartment;
    }

    public String getThtv() {
        return thtv;
    }

    public void setThtv(String thtv) {
        this.thtv = thtv;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
