package com.solera.flight.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FLIGHT")
@Data
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flightId;
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
