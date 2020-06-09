package com.infy.aeroFlights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.aeroFlights.entity.Administrator;

public interface AdministrationRepository  extends JpaRepository<Administrator, Integer>{

}
