package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.FlightMangementSystem.DTO.Airport;
import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.DTO.Schedule;
import com.project.FlightMangementSystem.DTO.ScheduledFlight;

public interface ScheduleFlightService {

    ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight);

    List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport, LocalDate date);
    
 

    ScheduledFlight viewScheduledFlight(BigInteger flightNumber);

    List<ScheduledFlight> viewScheduledFlight();

    ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int availableSeats) throws FlightNotFoundException;

    void deleteScheduledFlight(BigInteger flightNumber);

    void validateScheduledFlight(ScheduledFlight scheduledFlight) throws FlightNotFoundException;

}
