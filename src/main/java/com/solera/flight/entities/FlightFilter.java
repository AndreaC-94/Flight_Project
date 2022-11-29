package com.solera.flight.entities;

import java.time.LocalDate;

public class FlightFilter {

    private CityEnum origin;
    private CityEnum destination;
    private LocalDate date;

    public CityEnum getOrigin() {
        return origin;
    }
    public void setOrigin(CityEnum origin) {
        this.origin = origin;
    }
    public CityEnum getDestination() {
        return destination;
    }
    public void setDestination(CityEnum destination) {
        this.destination = destination;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
