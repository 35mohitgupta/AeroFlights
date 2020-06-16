package com.infy.aeroFlights.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.aeroFlights.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{

	@Query(value = "select f FROM Flight f where f.source = ?1 and f.destination = ?2 and f.departure between ?3 and ?4")
	List<Flight> findBySourceDestinationAndDeparture(String source, String destination, LocalDateTime startTime,LocalDateTime endTime);
}
