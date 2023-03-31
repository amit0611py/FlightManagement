package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FlightMangementSystem.DAO.FlightDao;
import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.Exception.InvalidFlightException;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightDao flightDao;

    @Override
    public Flight addFlight(Flight flight) throws InvalidFlightException{
        validateFlight(flight);
        return flightDao.addFlight(flight);
    }

    @Override
    public Flight modifyFlight(Flight flight) throws InvalidFlightException{
        validateFlight(flight);
        return flightDao.modifyFlight(flight);
    }

    @Override
    public Flight viewFlight(BigInteger flightNumber) {
        return flightDao.viewFlight(flightNumber);
    }

    @Override
    public List<Flight> viewFlight() {
        return flightDao.viewFlight();
    }

    @Override
    public void deleteFlight(BigInteger flightNumber) {
        flightDao.deleteFlight(flightNumber);
    }
    
    @Override
    public void validateFlight(Flight flight) throws InvalidFlightException {
        if (flight.getFlightModel() == null || flight.getFlightModel().isEmpty()) {
            throw new InvalidFlightException("Flight model cannot be null or empty");
        }
        if (flight.getCarrierName() == null || flight.getCarrierName().isEmpty()) {
            throw new InvalidFlightException("Carrier name cannot be null or empty");
        }
        if (flight.getSeatCapacity() <= 0) {
            throw new InvalidFlightException("Seat capacity cannot be less than or equal to zero");
        }
    }

}
