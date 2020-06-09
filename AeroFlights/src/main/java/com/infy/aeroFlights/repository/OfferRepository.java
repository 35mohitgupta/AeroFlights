package com.infy.aeroFlights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.aeroFlights.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, String>{

}
