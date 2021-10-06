package com.example.bigbowlxp;

import com.example.bigbowlxp.models.Activity;
import com.example.bigbowlxp.models.Beverage;
import com.example.bigbowlxp.models.Booking;
import com.example.bigbowlxp.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

@SpringBootTest
public class PriceCalculatorTests {
    @Autowired
    BookingService bookingService;

    @Test
    void calculatePriceTest(){
        Booking booking = new Booking();
        booking.setDuration(2);
        booking.setActivity(Activity.BOWLING);
        ArrayList<Beverage> beverages = new ArrayList<>(){{
            add(new Beverage(1, "sodavand", 25.00));
            add(new Beverage(1, "sodavand", 25.00));
            add(new Beverage(2, "øl", 30.00));
            add(new Beverage(2, "øl", 30.00));
        }};
        assertEquals(710, bookingService.priceCalculator(booking, beverages));
    }
}
