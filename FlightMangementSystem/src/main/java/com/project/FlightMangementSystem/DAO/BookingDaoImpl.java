package com.project.FlightMangementSystem.DAO;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;

import com.project.FlightMangementSystem.DTO.Booking;

public class BookingDaoImpl implements BookingDao {
    private List<Booking> bookingList;

    public BookingDaoImpl() {
        bookingList = new ArrayList<Booking>();
    }

    @Override
    public Booking addBooking(Booking booking) {
        bookingList.add(booking);
        return booking;
    }

    @Override
    public Booking modifyBooking(Booking booking) {
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getBookingId().equals(booking.getBookingId())) {
                bookingList.set(i, booking);
                return booking;
            }
        }
        return null;
    }

    @Override
    public List<Booking> viewBooking() {
        return bookingList;
    }

    @Override
    public void deleteBooking(BigInteger bookingId) {
//        for (int i = 0; i < bookingList.size(); i++) {
//            if (bookingList.get(i).getBookingId().equals(bookingId)) {
//                bookingList.remove(i);
//                break;
    	bookingList.removeIf(b -> b.getBookingId().equals(bookingId));
//            }
//        }
    }
    
    @Override
    public List<Booking> viewBooking(BigInteger bookingId) {
        List<Booking> bookings = new ArrayList<Booking>();
        for (Booking booking : bookingList) {
            if (booking.getBookingId().equals(bookingId)) {
                bookings.add(booking);
            }
        }
        return bookings;
    }
}
