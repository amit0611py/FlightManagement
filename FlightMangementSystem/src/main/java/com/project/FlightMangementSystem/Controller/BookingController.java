package com.project.FlightMangementSystem.Controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FlightMangementSystem.DTO.Booking;
import com.project.FlightMangementSystem.Exception.InvalidBookingException;
import com.project.FlightMangementSystem.Service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;
    
    @PostMapping("/")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        try {
            Booking newBooking = bookingService.addBooking(booking);
            return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
        } catch (InvalidBookingException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/")
    public ResponseEntity<Booking> modifyBooking(@RequestBody Booking booking) {
        try {
            Booking modifiedBooking = bookingService.modifyBooking(booking);
            return new ResponseEntity<>(modifiedBooking, HttpStatus.OK);
        } catch (InvalidBookingException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{bookingId}")
    public ResponseEntity<List<Booking>> viewBooking(@PathVariable BigInteger bookingId) {
        try {
            List<Booking> bookingList = bookingService.viewBooking(bookingId);
            return new ResponseEntity<>(bookingList, HttpStatus.OK);
        } catch (InvalidBookingException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Booking>> viewAllBookings() {
        List<Booking> bookingList = bookingService.viewBooking();
        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }
    
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable BigInteger bookingId) {
        try {
            bookingService.deleteBooking(bookingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InvalidBookingException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}