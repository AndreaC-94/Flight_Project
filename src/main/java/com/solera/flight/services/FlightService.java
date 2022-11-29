package com.solera.flight.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.flight.repositories.FlightRepository;

@Service
public class FlightService {
    
    @Autowired
    FlightRepository flightRepository;
}
