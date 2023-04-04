package com.project.FlightMangementSystem.DTO;

import java.math.BigInteger;

public class Flight {
    private BigInteger flightNumber;
    private String flightModel;
    private String carrierName;
    private Integer seatCapacity;

    public Flight(BigInteger flightNumber, String flightModel, String carrierName, Integer seatCapacity) {
        this.flightNumber = flightNumber;
        this.flightModel = flightModel;
        this.carrierName = carrierName;
        this.seatCapacity = seatCapacity;
    }

    // Getters and setters
    public BigInteger getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(BigInteger flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
