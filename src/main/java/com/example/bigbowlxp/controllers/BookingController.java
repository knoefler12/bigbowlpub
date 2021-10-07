package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.models.Activity;
import com.example.bigbowlxp.models.Beverage;
import com.example.bigbowlxp.models.Booking;
import com.example.bigbowlxp.models.BookingBeverage;
import com.example.bigbowlxp.services.BookingService;
import com.example.bigbowlxp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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

    @GetMapping("/bowlingBookings/{bookingId}")
    public String updateBowlingBookings(@PathVariable int bookingId,
                                        @RequestParam int sodaAmount,
                                        @RequestParam int beerAmount){
        Booking booking = bookingService.fetchBookingById(bookingId);
        try{
            booking.getBeverages();
        }catch(Exception e){
            booking.setBeverages(new List<BookingBeverage>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<BookingBeverage> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(BookingBeverage bookingBeverage) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends BookingBeverage> c) {
                    return false;
                }

                @Override
                public boolean addAll(int index, Collection<? extends BookingBeverage> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public BookingBeverage get(int index) {
                    return null;
                }

                @Override
                public BookingBeverage set(int index, BookingBeverage element) {
                    return null;
                }

                @Override
                public void add(int index, BookingBeverage element) {

                }

                @Override
                public BookingBeverage remove(int index) {
                    return null;
                }

                @Override
                public int indexOf(Object o) {
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
                    return 0;
                }

                @Override
                public ListIterator<BookingBeverage> listIterator() {
                    return null;
                }

                @Override
                public ListIterator<BookingBeverage> listIterator(int index) {
                    return null;
                }

                @Override
                public List<BookingBeverage> subList(int fromIndex, int toIndex) {
                    return null;
                }
            });
        }

        try {
            booking.getBeverages().get(0).setAmount(sodaAmount);
        }catch(Exception e){
            booking.getBeverages().add(new BookingBeverage(bookingId, 1, sodaAmount));
        }
        try {
            booking.getBeverages().get(1).setAmount(beerAmount);
        }catch (Exception e){
            booking.getBeverages().add(new BookingBeverage(bookingId, 2, beerAmount));
        }
        bookingService.editBookingBeverages(booking.getBeverages().get(0));
        bookingService.editBookingBeverages(booking.getBeverages().get(1));

        return "redirect:/bowlingBookings";
    }
}
