package com.solera.flight.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.solera.flight.services.FlightService;

@RestController
public class FlightController {
    
    @Autowired
    FlightService flightService;
}
