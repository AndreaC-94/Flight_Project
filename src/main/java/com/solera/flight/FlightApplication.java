package com.solera.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solera.flight.controllers.FlightController;

@SpringBootApplication
public class FlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);

		FlightController fc = new FlightController();
		fc.createFlight();
	}

}
