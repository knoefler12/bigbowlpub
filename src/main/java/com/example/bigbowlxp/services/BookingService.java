package com.example.bigbowlxp.services;

import com.example.bigbowlxp.models.AirHockeyTable;
import com.example.bigbowlxp.models.Booking;
import com.example.bigbowlxp.repositories.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
BookingRepo bookingRepo = new BookingRepo();


public void createBooking(Booking b){

     bookingRepo.createBooking(b);

    }


    public void deleteBooking(int id){

    bookingRepo.deleteBooking(id);
    }
    public List<Booking> fetchAirHockeyTableBooking(){
        return bookingRepo.fetchAirHockeyTableBooking();
    }
    public void deleteJoinedBooking(int id){
    bookingRepo.deleteJoinedBookings(id);
    }

    public List<Booking> fetchBookingById(String activity){
        return bookingRepo.fetchBookingByActivity(activity);
/*
    public void fetchBookingById(int id){
        bookingRepo.fetchBookingById(id);
    }

 */


}
