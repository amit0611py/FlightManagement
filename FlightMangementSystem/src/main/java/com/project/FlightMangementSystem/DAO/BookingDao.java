package com.project.FlightMangementSystem.DAO;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.FlightMangementSystem.DTO.Booking;


public interface BookingDao {
    
    Booking addBooking(Booking booking);
    
    Booking modifyBooking(Booking booking);
    
    List<Booking> viewBooking(BigInteger userId);
    
    List<Booking> viewBooking();
    
    void deleteBooking(BigInteger bookingId);
    
}
