package com.solera.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solera.flight.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    
}
