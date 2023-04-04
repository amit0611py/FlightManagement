package com.project.FlightMangementSystem.DAO;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.FlightMangementSystem.DTO.Airport;
import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.DTO.Schedule;
import com.project.FlightMangementSystem.DTO.ScheduledFlight;

@Repository
public class ScheduledFlightDaoImpl implements ScheduledFlightDao {

    private List<ScheduledFlight> scheduledFlightList = new ArrayList<>();

    @Override
    public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
        scheduledFlightList.add(scheduledFlight);
        return scheduledFlight;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(Airport source, Airport destination, LocalDate date) {
        List<ScheduledFlight> flights = new ArrayList<>();
        for (ScheduledFlight flight : scheduledFlightList) {
            if (flight.getSchedule().getSourceAirport().equals(source)
                    && flight.getSchedule().getDestinationAirport().equals(destination)
                    && flight.getSchedule().getDepartureTime().toLocalDate().equals(date)) {
                flights.add(flight);
            }
        }
        return flights;
    }

    @Override
    public ScheduledFlight viewScheduledFlights(BigInteger flightNumber) {
        for (ScheduledFlight flight : scheduledFlightList) {
            if (flight.getFlight().getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        return scheduledFlightList;
    }
    
    @Override
    public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int availableSeats) {
        ScheduledFlight scheduledFlight = viewScheduledFlights(flight.getFlightNumber());
        if (scheduledFlight != null) {
            scheduledFlight.setFlight(flight);
            scheduledFlight.setSchedule(schedule);
            scheduledFlight.setAvailableSeats(availableSeats);
        }
        return scheduledFlight;
    }

    @Override
    public void deleteScheduledFlight(BigInteger flightNumber) {
        ScheduledFlight scheduledFlight = viewScheduledFlights(flightNumber);
        if (scheduledFlight != null) {
            scheduledFlightList.remove(scheduledFlight);
        }
    }
}
