package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.FlightMangementSystem.DAO.BookingDao;
import com.project.FlightMangementSystem.DTO.Booking;
import com.project.FlightMangementSystem.DTO.Passenger;
import com.project.FlightMangementSystem.Exception.InvalidPassengerException;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingDao bookingDao;

    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public Booking addBooking(Booking booking) throws InvalidPassengerException{
    	for (Passenger passenger : booking.getPassengerList()) {
    		validatePassenger(passenger);
        }
        return bookingDao.addBooking(booking);
    }

    @Override
    public Booking modifyBooking(Booking booking) {
        return bookingDao.modifyBooking(booking);
    }

    @Override
    public List<Booking> viewBooking() {
        return bookingDao.viewBooking();
    }

    @Override
    public void deleteBooking(BigInteger bookingId) {
        bookingDao.deleteBooking(bookingId);
    }

    @Override
    public List<Booking> viewBooking(BigInteger bookingId) {
        return bookingDao.viewBooking(bookingId);
    }

    @Override
    public void validateBooking(Booking booking) {
        // validation logic
    }
    
    @Override
    public void validatePassenger(Passenger passenger) throws InvalidPassengerException {
        // Validation for Aadhaar Number
        BigInteger passengerUIN = passenger.getPassengerUIN();
        if (passengerUIN == null) {
            throw new InvalidPassengerException("Passenger UIN cannot be null");
        }
        if (passengerUIN.toString().length() != 12) {
            throw new InvalidPassengerException("Passenger UIN should be a 12-digit Aadhaar Number");
        }
        // Check if passengerUIN already exists in the bookings
        List<Booking> bookings = bookingDao.viewBooking();
        for (Booking booking : bookings) {
            List<Passenger> passengers = booking.getPassengerList();
            for (Passenger p : passengers) {
                if (passengerUIN.equals(p.getPassengerUIN())) {
                    throw new InvalidPassengerException("A passenger with this UIN already exists in another booking");
                }
            }
        }
    }
}
