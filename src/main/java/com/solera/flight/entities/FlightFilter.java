package com.solera.flight.entities;

import java.time.LocalDate;

public class FlightFilter {

    private int origin;
    private int destination;
    private LocalDate date;

    public int getOrigin() {
        return origin;
    }
    public void setOrigin(int origin) {
        this.origin = origin;
    }
    public int getDestination() {
        return destination;
    }
    public void setDestination(int destination) {
        this.destination = destination;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
