package com.project.FlightMangementSystem.DAO;

import java.util.List;

import com.project.FlightMangementSystem.DTO.Airport;

public interface AirportDao {
	
	List<Airport> viewAirport();

	Airport viewAirport(String airportCode);

//	void addAirport(Airport airport);
//
//	void deleteAirport(String airportCode);
//
//	void updateAirport(Airport airport);

}
