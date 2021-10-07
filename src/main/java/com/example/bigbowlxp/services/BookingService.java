package com.example.bigbowlxp.services;

import com.example.bigbowlxp.models.*;
import com.example.bigbowlxp.repositories.BookingRepo;
import com.example.bigbowlxp.repositories.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private BookingRepo bookingRepo;

    public void createBooking(Booking b){
     bookingRepo.createBooking(b);
    }

    public Booking fetchBookingById(int id){
        return bookingRepo.fetchBookingById(id);
    }

    public void deleteBooking(int id) {
    bookingRepo.deleteBooking(id);
    }

    public List<Booking> fetchAirHockeyTableBooking(){
        return bookingRepo.fetchAirHockeyTableBooking();
    }

    public List<Booking> fetchBowlingBooking(){
        return bookingRepo.fetchBowlingBooking();
    }
    public List<Booking> fetchRestaurantBooking(){
        return bookingRepo.fetchRestaurantBooking();
    }
    public void deleteJoinedBooking(int id){
    bookingRepo.deleteJoinedBookings(id);
    }


@Autowired
    public void setBookingRepo(BookingRepo bookingRepo) {
    this.bookingRepo = bookingRepo;
}

    public BookingRepo getBookingRepo() {
        return bookingRepo;
    }

    public void editBookingBeverages(BookingBeverage bb){
        bookingRepo.editBookingBeverages(bb);
    }




}
