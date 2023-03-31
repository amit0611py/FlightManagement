package com.project.FlightMangementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FlightMangementSystem.DTO.Airport;
import com.project.FlightMangementSystem.Service.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

   
    @GetMapping("/")
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airportList = airportService.viewAirport();
        return new ResponseEntity<>(airportList, HttpStatus.OK);
    }

 
    @GetMapping("/{code}")
    public ResponseEntity<Airport> getAirportByCode(@PathVariable String code) {
        Airport airport = airportService.viewAirport(code);
        if (airport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }
}
