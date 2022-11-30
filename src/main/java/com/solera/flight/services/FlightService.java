package com.solera.flight.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.flight.entities.CityEnum;
import com.solera.flight.entities.Flight;
import com.solera.flight.entities.FlightFilter;
import com.solera.flight.repositories.FlightRepository;

@Service
public class FlightService {
    
    @Autowired
    FlightRepository flightRepository;

    public String createFlight() {
        int k=0;
        int p=1;
        CityEnum origin;
        CityEnum destination = CityEnum.BERLIN;
        LocalDate dates = LocalDate.of(2022, 11, 29);
        for(int i=0; i<71; i++){
            for(int j=1; j<10; j++){
                switch(p) {
                    case 1 -> origin = CityEnum.BERLIN;
                    case 2 -> origin = CityEnum.DUBLIN;
                    case 3 -> origin = CityEnum.LISBON;
                    case 4 -> origin = CityEnum.LONDON;
                    case 5 -> origin = CityEnum.MADRID;
                    case 6 -> origin = CityEnum.PARIS;
                    case 7 -> origin = CityEnum.ROME;
                    case 8 -> origin = CityEnum.TOKYO;
                    case 9 -> {
                        origin = CityEnum.WASHINGTON;
                        p = 0;
                    }
                    default -> origin = CityEnum.ROME;              
                }
                if(origin != destination){
                    Flight flight = new Flight(origin, destination, dates);
                    flightRepository.save(flight);
                }
                else{
                    k++;
                }
                p++;
            }
            switch(k) {
                case 0 -> destination = CityEnum.BERLIN;
                case 1 -> destination = CityEnum.DUBLIN;
                case 2 -> destination = CityEnum.LISBON;
                case 3 -> destination = CityEnum.LONDON;
                case 4 -> destination = CityEnum.MADRID;
                case 5 -> destination = CityEnum.PARIS;
                case 6 -> destination = CityEnum.ROME;
                case 7 -> destination = CityEnum.TOKYO;
                case 8 -> {
                    destination = CityEnum.WASHINGTON;
                    k = 0;
                }
                default -> {
                    destination = CityEnum.ROME;
                    k=0;
                }         
            }
            dates = dates.plusDays(1);
        }
        return "Flights created correctly!";
    }

    public List<Flight> getAllFlight() {
        return flightRepository.flights;
    }

    public List<Flight> getFilteredFlight(FlightFilter flightFilter) {
        
        return flightRepository.flights
        .stream()
        .filter(x -> x.getOrigin() == CityEnum.values()[flightFilter.getOrigin()])
        .filter(x -> x.getDestination() == CityEnum.values()[flightFilter.getDestination()])
        .filter(x -> x.getDate().isAfter(flightFilter.getDate().plusDays(-3))).toList();
    }

    public List<String> getLocation() {
        List<String> cities = new ArrayList<>();
        for (CityEnum city : CityEnum.values()) {
            cities.add(city.toString());
        }
        return cities;
    }

}
