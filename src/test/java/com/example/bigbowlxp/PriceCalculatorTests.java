package com.example.bigbowlxp;

import com.example.bigbowlxp.models.Activity;
import com.example.bigbowlxp.models.Beverage;
import com.example.bigbowlxp.models.Booking;
import com.example.bigbowlxp.models.BookingBeverage;
import com.example.bigbowlxp.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PriceCalculatorTests {
    @Autowired
    BookingService bookingService;

    @Test
    void calculatePriceTest(){
        Booking booking = new Booking();
        booking.setDuration(2);
        booking.setActivity(Activity.BOWLING);
        List<BookingBeverage> beverages = new ArrayList<>(){{
            add(new BookingBeverage(1, 1, "sodavand", 25.00, 2));
            add(new BookingBeverage(1, 2, "øl", 30.00, 2));
        }};
        booking.setBeverages(beverages);
        assertEquals(710, bookingService.priceCalculator(booking));
    }


}
