package com.example.bigbowlxp;

import com.example.bigbowlxp.controllers.BookingController;
import com.example.bigbowlxp.models.Activity;
import com.example.bigbowlxp.models.Booking;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookingTest {

    @Autowired
    static BookingController bookingController;

    @BeforeAll
    static void setup(){
        try {
            bookingController.deleteBooking(Integer.MAX_VALUE);
        }catch (Exception e){

        }
    }

    @Test
    void createAndDeleteBookingTest(){


        assertFalse(bookingController.getBookingService().fetchBowlingBooking().stream().anyMatch(book -> book.getBookingId() == Integer.MAX_VALUE ));



        Booking booking = new Booking();
        booking.setBookingId(Integer.MAX_VALUE);
        booking.setActivity(Activity.BOWLING);
        booking.setFirstName("Jørgen");
        booking.setLastName("Biil");
        booking.setDuration(10);
        booking.setPhone("qwerty");
        booking.setDate(LocalDate.of(2020,10,10).toString());
        booking.setStartTime("12:45");

        bookingController.getBookingService().createBooking(booking);

        List<Booking> bookings;
        bookings = bookingController.getBookingService().fetchBowlingBooking();
        assertTrue(bookings.stream().anyMatch(book -> book.getBookingId() == Integer.MAX_VALUE ));

        for(Booking b : bookings){
            if (b.getBookingId() == Integer.MAX_VALUE) {
                booking = b;
            }
        }

        assertEquals(Integer.MAX_VALUE,booking.getBookingId());
        assertEquals(Activity.BOWLING,booking.getActivity());
        assertEquals("Jørgen",booking.getFirstName());
        assertEquals("Biil",booking.getLastName());
        assertEquals(10,booking.getDuration());
        assertEquals("qwerty",booking.getPhone());
        assertEquals(LocalDate.of(2020,10,10),booking.getDate());
        assertEquals("12:45", booking.getStartTime());

        bookingController.deleteBooking(Integer.MAX_VALUE);

        assertFalse(bookingController.getBookingService().fetchBowlingBooking().stream().anyMatch(book -> book.getBookingId() == Integer.MAX_VALUE ));

    }


    @AfterAll
    static void cleanUp(){
        try {
            bookingController.deleteBooking(Integer.MAX_VALUE);
        }catch (Exception e){

        }
    }


}
