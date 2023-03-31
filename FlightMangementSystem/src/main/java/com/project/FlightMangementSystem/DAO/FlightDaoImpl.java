package com.project.FlightMangementSystem.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.FlightMangementSystem.DTO.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

    private List<Flight> flightList = new ArrayList<>();

    @Override
    public Flight addFlight(Flight flight) {
        flightList.add(flight);
        return flight;
    }

    @Override
    public Flight modifyFlight(Flight flight) {
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getFlightNumber().equals(flight.getFlightNumber())) {
                flightList.set(i, flight);
                return flight;
            }
        }
        return null;
    }

    @Override
    public Flight viewFlight(BigInteger flightNumber) {
        for (Flight flight : flightList) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    @Override
    public List<Flight> viewFlight() {
        return flightList;
    }

    @Override
    public void deleteFlight(BigInteger flightNumber) {
        Flight flight = viewFlight(flightNumber);
        if (flight != null) {
            flightList.remove(flight);
        }
    }
}
