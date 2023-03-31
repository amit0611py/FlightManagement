package com.project.FlightMangementSystem.DAO;

import java.util.List;
import java.util.ArrayList;

import com.project.FlightMangementSystem.DTO.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportDaoImpl implements AirportDao {

    private List<Airport> airportList;

    public AirportDaoImpl() {
        airportList = new ArrayList<>();
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

//    public void addAirport(Airport airport) {
//        airportList.add(airport);
//    }
//
//    public void deleteAirport(String airportCode) {
//        for (Airport airport : airportList) {
//            if (airport.getAirportCode().equals(airportCode)) {
//                airportList.remove(airport);
//                break;
//            }
//        }
//    }
//
//    public void updateAirport(Airport airport) {
//        for (Airport a : airportList) {
//            if (a.getAirportCode().equals(airport.getAirportCode())) {
//                a.setAirportName(airport.getAirportName());
//                a.setAirportLocation(airport.getAirportLocation());
//                break;
//            }
//        }
//    }
}

