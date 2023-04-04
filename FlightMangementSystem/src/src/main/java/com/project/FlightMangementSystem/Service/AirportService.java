package com.project.FlightMangementSystem.Service;

import java.util.List;

import com.project.FlightMangementSystem.DTO.Airport;

public interface AirportService {
    
    List<Airport> viewAirport();
    
    Airport viewAirport(String airportCode);
    
}