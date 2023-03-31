package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.FlightMangementSystem.DAO.BookingDao;
import com.project.FlightMangementSystem.DTO.Booking;
import com.project.FlightMangementSystem.DTO.Passenger;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingDao bookingDao;

    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public Booking addBooking(Booking booking) {
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
    public void validatePassenger(Passenger passenger) {
        // validation logic
    }
}