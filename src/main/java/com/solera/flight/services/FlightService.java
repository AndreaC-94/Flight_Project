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
        CityEnum destination = CityEnum.ROME;
        LocalDate dates = LocalDate.of(2022, 11, 30);
        for(int i=0; i<71; i++){
            for(int j=1; j<81; j++){
                origin = getCity(p);
                if(p >= 9) p = 0;

                if(origin != destination){
                    Flight flight = new Flight(origin, destination, dates);
                    flightRepository.save(flight);
                }
                else{
                    k++;
                    destination = getCity(k);
                    if(k >= 9) k = 0;
                    p++;
                }
                p++;
            }
            dates = dates.plusDays(1);
        }
        return "Flights created correctly!";
    }

    private CityEnum getCity(int i){ //NOT AN API!!!
        CityEnum city;
        switch(i) {
            case 1 -> city = CityEnum.ROME;
            case 2 -> city = CityEnum.BERLIN;
            case 3 -> city = CityEnum.PARIS;
            case 4 -> city = CityEnum.LONDON;
            case 5 -> city = CityEnum.MADRID;
            case 6 -> city = CityEnum.LISBON;
            case 7 -> city = CityEnum.WASHINGTON;
            case 8 -> city = CityEnum.TOKYO;
            case 9 -> city = CityEnum.DUBLIN;
            default -> city = CityEnum.ROME;              
        }
        return city;
    }

    public List<Flight> getAllFlight() {
        return FlightRepository.flights;
    }

    public List<Flight> getFilteredFlight(FlightFilter flightFilter) {
        
        return FlightRepository.flights
        .stream()
        .filter(x -> x.getOrigin() == CityEnum.values()[flightFilter.getOrigin()])
        .filter(x -> x.getDestination() == CityEnum.values()[flightFilter.getDestination()])
        .filter(x -> x.getDate().isAfter(flightFilter.getDate().minusDays(3)))
        .filter(x -> x.getDate().isBefore(flightFilter.getDate().plusDays(3))).toList();
    }

    public List<String> getLocation() {
        List<String> cities = new ArrayList<>();
        for (CityEnum city : CityEnum.values()) {
            cities.add(city.toString());
        }
        return cities;
    }

    public Flight getFlight(String id) throws Exception {
        for (Flight f : FlightRepository.flights) {
            if(f.getFlightId().equals(id)) return f;
        }
        throw new Exception("We couln't find the flight with id: " + id);
    }

}
