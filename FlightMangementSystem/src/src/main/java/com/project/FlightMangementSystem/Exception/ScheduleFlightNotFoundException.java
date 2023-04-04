package com.project.FlightMangementSystem.Exception;

public class ScheduleFlightNotFoundException extends RuntimeException {
    public ScheduleFlightNotFoundException(String message) {
        super(message);
    }
}