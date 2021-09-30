package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.Booking;
import com.example.bigbowlxp.models.BowlingLane;
import com.example.bigbowlxp.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

        String sql = "INSERT INTO bookings(customerId, activity, date, startTime, duration) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, b.getCustomerId(), b.getActivity(), b.getDate(), b.getStartTime(), b.getDuration());

}
    public void deleteBooking(int id){

        String sql ="DELETE FROM bookings WHERE bookingId = ?";
        jdbcTemplate.update(sql,id);
}
public void deleteJoinedBookings(int id){
        String sql = "DELETE FROM bookings_unit WHERE booking_id = ?";
        jdbcTemplate.update(sql, id);
}

public List<Booking> fetchBookingByActivity(String activity){

        String sql = "SELECT * FROM bookings WHERE activity = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);

        return jdbcTemplate.query(sql,rowMapper,activity);
}


}
