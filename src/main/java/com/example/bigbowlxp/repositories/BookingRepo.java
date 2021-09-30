package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookingRepo{
private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }
    public void createBooking(Booking b ){

        String sql = "INSERT INTO bookings(customerId, firstName, lastName, phone, activity, date, startTime, duration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, b.getCustomerId(), b.getFirstName(), b.getLastName(), b.getPhone(), b.getActivity(), b.getDate(), b.getStartTime(), b.getDuration());

}
    public void deleteBooking(int id){

        String sql ="DELETE FROM bookings WHERE bookingId = ?";
        jdbcTemplate.update(sql,id);
}
public void deleteJoinedBookings(int id){
        String sql = "DELETE FROM bookings_unit WHERE booking_id = ?";
        jdbcTemplate.update(sql, id);
}

public ArrayList<Booking> bowlingBooking(){
        ArrayList<Booking> listOfBowlingBooking = new ArrayList<>();
        String sql = ""
}

}
