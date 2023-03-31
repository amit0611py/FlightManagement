package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FlightMangementSystem.DAO.ScheduledFlightDao;
import com.project.FlightMangementSystem.DTO.Airport;
import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.DTO.Schedule;
import com.project.FlightMangementSystem.DTO.ScheduledFlight;
import com.project.FlightMangementSystem.Exception.ScheduleFlightNotFoundException;

@Service
public class ScheduleFlightServicesImpl implements ScheduleFlightService {

    @Autowired
    private ScheduledFlightDao scheduledFlightDao;

    @Override
    public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
        return scheduledFlightDao.scheduleFlight(scheduledFlight);
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport, LocalDate date) {
        return scheduledFlightDao.viewScheduledFlights(sourceAirport, destinationAirport, date);
    }

    @Override
    public ScheduledFlight viewScheduledFlight(BigInteger flightNumber) {
        ScheduledFlight scheduledFlight = scheduledFlightDao.viewScheduledFlights(flightNumber);
        if (scheduledFlight == null) {
            throw new ScheduleFlightNotFoundException("Scheduled flight with flight number " + flightNumber + " not found.");
        }
        return scheduledFlight;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        return scheduledFlightDao.viewScheduledFlight();
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int availableSeats) throws FlightNotFoundException {
        ScheduledFlight scheduledFlight = scheduledFlightDao.viewScheduledFlights(flight.getFlightNumber());
        try {
			if (scheduledFlight == null) {
			    throw new FlightNotFoundException("Flight with flight number " + flight.getFlightNumber() + " not found.");
			}
		} catch (FlightNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        scheduledFlight.setFlight(flight);
        scheduledFlight.setSchedule(schedule);
        scheduledFlight.setAvailableSeats(availableSeats);
        return scheduledFlightDao.scheduleFlight(scheduledFlight);
    }
    
    @Override
    public void deleteScheduledFlight(BigInteger flightNumber) {
        ScheduledFlight scheduledFlight = scheduledFlightDao.viewScheduledFlights(flightNumber);
        if (scheduledFlight == null) {
            throw new ScheduleFlightNotFoundException("Scheduled flight with flight number " + flightNumber + " not found.");
        }
        scheduledFlightDao.deleteScheduledFlight(flightNumber);
    }

    @Override
    public void validateScheduledFlight(ScheduledFlight scheduledFlight) throws FlightNotFoundException {
        try {
			if (scheduledFlight.getFlight() == null) {
			    throw new FlightNotFoundException("Flight is mandatory.");
			}
		} catch (FlightNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (scheduledFlight.getSchedule() == null) {
            throw new RuntimeException("Schedule is mandatory.");
        }
        if (scheduledFlight.getAvailableSeats() < 0) {
            throw new RuntimeException("Invalid available seats.");
        }
    }

}