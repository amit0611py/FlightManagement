package com.project.FlightMangementSystem.DAO;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.FlightMangementSystem.DTO.Airport;
import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.DTO.Schedule;
import com.project.FlightMangementSystem.DTO.ScheduledFlight;

//@Repository
public interface ScheduledFlightDao {
    ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight);

    List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport, LocalDate date);

    ScheduledFlight viewScheduledFlights(BigInteger flightNumber);

    List<ScheduledFlight> viewScheduledFlight();

    ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int availableSeats);

    void deleteScheduledFlight(BigInteger flightNumber);
}

//public interface ScheduledFlightDao {
//    ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight);
//
//    List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport, LocalDate date);
//
//    ScheduledFlight viewScheduledFlightById(BigInteger flightNumber);
//
//    List<ScheduledFlight> viewScheduledFlights();
//
//    ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int availableSeats);
//
//    void deleteScheduledFlight(BigInteger flightNumber);
//}
