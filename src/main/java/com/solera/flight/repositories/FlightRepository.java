package com.solera.flight.repositories;

import java.util.List;

import com.solera.flight.entities.Flight;

public class FlightRepository {

    public static List<Flight> flights;
    
    public void save(Flight flight){
        flights.add(flight);
    }
}
