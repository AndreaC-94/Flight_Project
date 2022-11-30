package com.solera.flight.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Flight {

    private String flightId;
    private String companyName;
    private CityEnum origin;
    private CityEnum destination;
    private LocalDate date;
    private int seats;
    private boolean luggageAllowed;
    private List<CityEnum> scales;
    private int basePrice;
    
    public Flight(CityEnum origin, CityEnum destination, LocalDate date){
        Random rd = new Random();
        this.flightId = UUID.randomUUID().toString().substring(0, 13);
        this.companyName = rd.nextBoolean() ? "Rayanair":"Iberia";
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.seats = rd.nextInt(51) + 70;
        this.luggageAllowed = rd.nextBoolean();
        this.scales = null;
        this.basePrice = rd.nextInt(201) + 45;
    }
}
