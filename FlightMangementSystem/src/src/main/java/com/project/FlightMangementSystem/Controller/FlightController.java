package com.project.FlightMangementSystem.Controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FlightMangementSystem.DTO.Flight;
import com.project.FlightMangementSystem.Exception.InvalidFlightException;
import com.project.FlightMangementSystem.Service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    
    @Autowired
    private FlightService flightService;

    @PostMapping("/")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight addedFlight;
		try {
			addedFlight = flightService.addFlight(flight);
		} catch (InvalidFlightException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Flight>> viewFlights() {
        List<Flight> flights = flightService.viewFlight();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<Flight> viewFlight(@PathVariable("flightNumber") BigInteger flightNumber) {
        Flight flight = flightService.viewFlight(flightNumber);
        if (flight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PutMapping("/{flightNumber}")
    public ResponseEntity<Flight> modifyFlight(@PathVariable("flightNumber") BigInteger flightNumber, @RequestBody Flight flight) {
        Flight modifiedFlight;
		try {
			modifiedFlight = flightService.modifyFlight(flight);
		} catch (InvalidFlightException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
        if (modifiedFlight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(modifiedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightNumber") BigInteger flightNumber) {
        flightService.deleteFlight(flightNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
