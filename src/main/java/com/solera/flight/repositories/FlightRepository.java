package com.solera.flight.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.solera.flight.entities.Flight;

@Component
public class FlightRepository {

    public static List<Flight> flights = new ArrayList<>();
    
    public void save(Flight flight){
        flights.add(flight);
    }
}
