package com.infy.aeroFlights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, String>{

	List<Offer> findByStatus(OfferStatus offerStatus);
	
	
	
}
