package com.project.FlightMangementSystem.Service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.project.FlightMangementSystem.DAO.AirportDao;
import com.project.FlightMangementSystem.DTO.Airport;

@Service
public class AirportServiceImpl implements AirportService {

//    @Autowired
//    private AirportDao airportDao;

    private List<Airport> airportList = new ArrayList<>();

    public AirportServiceImpl() {
        airportList.add(new Airport("DEL", "Indira Gandhi International Airport", "New Delhi"));
        airportList.add(new Airport("BOM", "Chhatrapati Shivaji International Airport", "Mumbai"));
        airportList.add(new Airport("MAA", "Chennai International Airport", "Chennai"));
        airportList.add(new Airport("BAN", "Bangalore International Airport","Bangalore")):
        airportList.add(new Airport("HIS","Hisar International Airport","Hisar"));
        airportList.add(new Airport("PUN", "Pune International Airport", "Pune"));
        
    }

    @Override
    public List<Airport> viewAirport() {
        return airportList;
    }

    @Override
    public Airport viewAirport(String airportCode) {
        for (Airport airport : airportList) {
            if (airport.getAirportCode().equals(airportCode)) {
                return airport;
            }
        }
        return null;
    }
}
