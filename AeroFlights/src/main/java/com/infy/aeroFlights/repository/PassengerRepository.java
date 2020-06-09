package com.infy.aeroFlights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.aeroFlights.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
