package com.solera.flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.flight.entities.Flight;
import com.solera.flight.entities.FlightFilter;
import com.solera.flight.services.FlightService;


@RestController
@RequestMapping("/flight")
public class FlightController {
    
    @Autowired
    FlightService flightService;

    @PostMapping
    @RequestMapping("/createMany")
    public ResponseEntity<String> createFlight(){
        try{
            String msg = flightService.createFlight();
            return new ResponseEntity<String>(msg, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    @RequestMapping("/getAllFlight")
    public ResponseEntity<?> getAllFlight(){
        try{
            List<Flight> msg = flightService.getAllFlight();
            return new ResponseEntity<List<Flight>>(msg, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping
    @RequestMapping("/getFilteredFlight")
    public ResponseEntity<?> getFilteredFlight(@RequestBody FlightFilter flightFilter){
        try{
            List<Flight> msg = flightService.getFilteredFlight(flightFilter);
            return new ResponseEntity<List<Flight>>(msg, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    @RequestMapping("/allLocation")
    public ResponseEntity<?> getLocation(){
        try{
            List<String> msg = flightService.getLocation();
            return new ResponseEntity<List<String>>(msg, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    @RequestMapping("/getFlight")
    public ResponseEntity<?> getFlight(@RequestBody String id){
        try{
            Flight flight = flightService.getFlight(id);
            return new ResponseEntity<Flight>(flight, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
