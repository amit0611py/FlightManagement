package com.project.FlightMangementSystem.Controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FlightMangementSystem.DTO.Airport;
import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.DTO.ScheduledFlight;
import com.project.FlightMangementSystem.Exception.InvalidFlightException;
import com.project.FlightMangementSystem.Service.AirportService;
import com.project.FlightMangementSystem.Service.FlightService;
import com.project.FlightMangementSystem.Service.ScheduleFlightService;

@RestController
@RequestMapping("/flights")
public class ScheduledFlightController {

    @Autowired
    private FlightService flightService;
    
    @Autowired
    private AirportService airportService;
    
    @Autowired
    private ScheduleFlightService scheduleFlightService;
    
    
    @GetMapping("/scheduled-flights")
    public ResponseEntity<List<ScheduledFlight>> viewScheduledFlights(@RequestParam("sourceAirportCode") String sourceAirportCode,
                                                                       @RequestParam("destinationAirportCode") String destinationAirportCode,
                                                                       @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Airport sourceAirport = airportService.viewAirport(sourceAirportCode);
        Airport destinationAirport = airportService.viewAirport(destinationAirportCode);
        List<ScheduledFlight> scheduledFlights = scheduleFlightService.viewScheduledFlights(sourceAirport, destinationAirport, date);
        return ResponseEntity.ok().body(scheduledFlights);
    }


    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        try {
            Flight addedFlight = flightService.addFlight(flight);
            return new ResponseEntity<Flight>(addedFlight, HttpStatus.CREATED);
        } catch (InvalidFlightException e) {
            return new ResponseEntity<Flight>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{flightNumber}")
    public ResponseEntity<Flight> modifyFlight(@PathVariable BigInteger flightNumber, @RequestBody Flight flight) {
        Flight modifiedFlight = flightService.viewFlight(flightNumber);
        if (modifiedFlight == null) {
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }
        try {
            modifiedFlight = flightService.modifyFlight(flight);
            return new ResponseEntity<Flight>(modifiedFlight, HttpStatus.OK);
        } catch (InvalidFlightException e) {
            return new ResponseEntity<Flight>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<Flight> viewFlight(@PathVariable BigInteger flightNumber) {
        Flight flight = flightService.viewFlight(flightNumber);
        if (flight == null) {
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Flight>(flight, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Flight>> viewFlight() {
        List<Flight> flights = flightService.viewFlight();
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }

    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<Void> deleteFlight(@PathVariable BigInteger flightNumber) {
        Flight flight = flightService.viewFlight(flightNumber);
        if (flight == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        flightService.deleteFlight(flightNumber);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}