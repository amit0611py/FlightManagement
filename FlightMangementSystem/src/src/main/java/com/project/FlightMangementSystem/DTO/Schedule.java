package com.project.FlightMangementSystem.DTO;

import java.time.LocalDateTime;

public class Schedule {
    private Airport sourceAirport;
    private Airport destinationAirport;
  //  @JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
    private LocalDateTime  arrivalTime;
    private LocalDateTime  departureTime;

    public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    // Getters and setters
    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}
