package com.project.FlightMangementSystem.DAO;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.project.FlightMangementSystem.DTO.Airport;
import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.DTO.Schedule;
import com.project.FlightMangementSystem.DTO.ScheduledFlight;

public interface ScheduledFlightDao {
    ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight);

    List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport, LocalDate date);

    ScheduledFlight viewScheduledFlights(BigInteger flightNumber);

    List<ScheduledFlight> viewScheduledFlight();

    ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int availableSeats);

    void deleteScheduledFlight(BigInteger flightNumber);
}
