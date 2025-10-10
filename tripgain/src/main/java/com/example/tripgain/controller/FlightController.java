package com.example.tripgain.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripgain.model.FlightInfo;
import com.example.tripgain.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // POST /api/flights/fetch-and-store
    @PostMapping("/fetch-and-store")
    public ResponseEntity<String> fetchAndStoreFlights() {
        try {
            flightService.fetchAndStoreFlights();
            return ResponseEntity.ok("Flights fetched and stored successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch and store flights: " + e.getMessage());
        }
    }

    // GET /api/flights - list all sorted by totalAmount ascending
    @GetMapping
    public ResponseEntity<List<FlightInfo>> getAllFlights() {
        List<FlightInfo> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    // GET /api/flights/{flightNumber} - get flight by flight number
    @GetMapping("/{flightNumber}")
    public ResponseEntity<?> getFlightByNumber(@PathVariable String flightNumber) {
        Optional<FlightInfo> flightOpt = flightService.getFlightByNumber(flightNumber);
        if (flightOpt.isPresent()) {
            return ResponseEntity.ok(flightOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Flight with number " + flightNumber + " not found.");
        }
    }

    // GET /api/flights/max-price - flight with max price
    @GetMapping("/max-price")
    public ResponseEntity<?> getFlightWithMaxPrice() {
        Optional<FlightInfo> flightOpt = flightService.getFlightWithMaxPrice();
        if (flightOpt.isPresent()) {
            return ResponseEntity.ok(flightOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flights found.");
        }
    }

    // GET /api/flights/min-price - flight with min price
    @GetMapping("/min-price")
    public ResponseEntity<?> getFlightWithMinPrice() {
        Optional<FlightInfo> flightOpt = flightService.getFlightWithMinPrice();
        if (flightOpt.isPresent()) {
            return ResponseEntity.ok(flightOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flights found.");
        }
    }
}
