package com.example.bigbowlxp.controllers;

import com.example.bigbowlxp.services.BookingService;
import com.example.bigbowlxp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    CustomerService customerService;
}
