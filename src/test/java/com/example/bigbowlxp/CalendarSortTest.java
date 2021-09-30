package com.example.bigbowlxp;

import com.example.bigbowlxp.controllers.BookingController;
import com.example.bigbowlxp.models.Activity;
import com.example.bigbowlxp.models.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class CalendarSortTest {

    @Autowired
    BookingController bookingController;

    @Test
    void test(){
        Booking booking = new Booking();
        booking.setBookingId(Integer.MAX_VALUE);
        booking.setBookingUnits(new ArrayList<>(){{add(1);add(2);}});
        booking.setActivity(Activity.BOWLING);
        booking.setFirstName("Jørgen");
        booking.setLastName("Biil");
        booking.setDuration(10);
        booking.setPhone("qwerty");
        booking.setStartTime(LocalDateTime.of(2020,10,10,5,10).toString());

        bookingController.getBookingService().createBooking(booking);

        ArrayList<Booking> bookings = bookingController.getBookingService().fetchBookingByDay(LocalDate.of(2020,9,10));
        for (Booking b : bookings) {
            if(b.getBookingId() == Integer.MAX_VALUE){
                fail("booking found in wrong list");
            }
        }

        bookings = bookingController.getBookingService().fetchBookingByDay(LocalDate.of(2020,10,10));
        boolean inList = false;
        for (Booking b : bookings) {
            if(b.getBookingId() == Integer.MAX_VALUE){
                inList = true;
            }
        }
        assertTrue(inList);
    }



}
