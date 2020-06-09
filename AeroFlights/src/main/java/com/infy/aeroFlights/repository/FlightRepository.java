package com.infy.aeroFlights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.aeroFlights.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{

}
