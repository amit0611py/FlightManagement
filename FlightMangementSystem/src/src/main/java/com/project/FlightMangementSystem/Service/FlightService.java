package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.util.List;

import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.Exception.InvalidFlightException;

public interface FlightService {
    
    public Flight addFlight(Flight flight) throws InvalidFlightException;
    
    public Flight modifyFlight(Flight flight) throws InvalidFlightException;
    
    public Flight viewFlight(BigInteger flightNumber);
    
    public List<Flight> viewFlight();
    
    public void deleteFlight(BigInteger flightNumber);
    
    public void validateFlight(Flight flight) throws InvalidFlightException;

}
