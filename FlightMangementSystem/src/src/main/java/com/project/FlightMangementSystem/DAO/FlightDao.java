package com.project.FlightMangementSystem.DAO;

import java.math.BigInteger;
import java.util.List;

import com.project.FlightMangementSystem.DTO.Flight;

public interface FlightDao {
    Flight addFlight(Flight flight);

    Flight modifyFlight(Flight flight);

    Flight viewFlight(BigInteger flightNumber);

    List<Flight> viewFlight();

    void deleteFlight(BigInteger flightNumber);
    
//    Flight updateFlight(Flight flight);
    
}

