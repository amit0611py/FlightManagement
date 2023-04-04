package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.FlightMangementSystem.DTO.Booking;
import com.project.FlightMangementSystem.DTO.Passenger;
import com.project.FlightMangementSystem.Exception.InvalidBookingException;
import com.project.FlightMangementSystem.Exception.InvalidPassengerException;


public interface BookingService {
    Booking addBooking(Booking booking) throws InvalidBookingException, InvalidPassengerException;
    Booking modifyBooking(Booking booking) throws InvalidBookingException;
    List<Booking> viewBooking(BigInteger bookingId) throws InvalidBookingException;
    List<Booking> viewBooking();
    void deleteBooking(BigInteger bookingId) throws InvalidBookingException;
    void validateBooking(Booking booking) throws InvalidBookingException;
    void validatePassenger(Passenger passenger) throws InvalidPassengerException;
}

