package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.Activity;
import com.example.bigbowlxp.models.Beverage;
import com.example.bigbowlxp.models.Booking;
import com.example.bigbowlxp.services.BookingService;
import com.example.bigbowlxp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {

    BookingService bookingService;


    public BookingService getBookingService() {
        return bookingService;
    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Autowired
    CustomerService customerService;

    @GetMapping("/airhockeybookings")
    public String getAllAirHockeyBookings(Model model){
        List<Booking> bookingList = bookingService.fetchAirHockeyTableBooking();
        model.addAttribute("airhockeybookings", bookingList);
        return "bookings";
    }

    @GetMapping("/bookings/{activity}")
    public String fetchBookingByActivity(@PathVariable String activity, Model model) {
        //Booking booking = bookingService.fetchBookingByActivity(activity);
        //model.addAttribute("booking", booking);
        return "booking";
    }

    

    @GetMapping("/createBooking")
    public String createBooking() {
        return "createBooking";
    }

    @PostMapping("/createBooking")
    public String createBooking(@ModelAttribute Booking booking){
        bookingService.createBooking(booking);
        return "redirect:/";
    }

    @GetMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
        bookingService.deleteJoinedBooking(id);
        return "redirect:/";
    }


    @GetMapping("/airhockeytablesbookings")
    public String fetchAirHockeyTables(Model model){

        List<Booking> bookings = bookingService.fetchAirHockeyTableBooking();
        model.addAttribute("airHockeyBookings", bookings);

        return "hockeyBookings.html";
    }

    @GetMapping("/bowlingbookings")
    public String fetchBowlingBookings(Model model){

        List<Booking> bookings = bookingService.fetchBowlingBooking();
        model.addAttribute("bowlingBookings", bookings);

        return "bowlingBookings.html";
    }

    @GetMapping("/restaurantbookings")
    public String fetchRestaurantBookings(Model model){

        List<Booking> bookings = bookingService.fetchRestaurantBooking();
        model.addAttribute("restaurantBookings", bookings);

        return "restaurantBookings.html";
    }

    @PostMapping("/bowlingBookings/{bookingId}")
    public String updateBowlingBookings(@ModelAttribute List<Booking> bookings){
        return "redirect:/bowlingBookings.html";
    }
}
