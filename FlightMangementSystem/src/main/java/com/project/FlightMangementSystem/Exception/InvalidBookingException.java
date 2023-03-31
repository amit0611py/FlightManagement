package com.project.FlightMangementSystem.Exception;

import java.lang.Exception;

public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

