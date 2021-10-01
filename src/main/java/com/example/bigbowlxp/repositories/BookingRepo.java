package com.example.bigbowlxp.repositories;

import com.example.bigbowlxp.models.AirHockeyTable;
import com.example.bigbowlxp.models.Booking;
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
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
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

    public ArrayList<Booking> bowlingBooking(){
        ArrayList<Booking> listOfBowlingBooking = new ArrayList<>();
        String sql = "";
        return null;
    }

    public List<Booking> fetchAirHockeyTableBooking(){
        String sql = "SELECT booking_id, b.customer_id, first_name, last_name, phone, activity, date, start_time, duration" +
                " FROM sql4438617.bookings b " +
                "JOIN sql4438617.customers USING (customer_id) " +
                "WHERE activity = 'AIRHOCKEY'" +
                "ORDER BY date, start_time";
        RowMapper<Booking> bookingRowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbcTemplate.query(sql, bookingRowMapper);
    }

    public List<Booking> fetchBowlingBooking(){
        String sql = "SELECT booking_id, b.customer_id, first_name, last_name, phone, activity, date, start_time, duration" +
                " FROM sql4438617.bookings b " +
                "JOIN sql4438617.customers USING (customer_id) " +
                "WHERE activity = 'BOWLING'" +
                "ORDER BY date, start_time";
        RowMapper<Booking> bookingRowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbcTemplate.query(sql, bookingRowMapper);
    }

    public List<Booking> fetchRestaurantBooking(){
        String sql = "SELECT booking_id, b.customer_id, first_name, last_name, phone, activity, date, start_time, duration" +
                " FROM sql4438617.bookings b " +
                "JOIN sql4438617.customers USING (customer_id) " +
                "WHERE activity = 'RESTAURENT'" +
                "ORDER BY date, start_time";
        RowMapper<Booking> bookingRowMapper = new BeanPropertyRowMapper<>(Booking.class);
        List<Booking> list = jdbcTemplate.query(sql, bookingRowMapper);
        return list;
    }
}
