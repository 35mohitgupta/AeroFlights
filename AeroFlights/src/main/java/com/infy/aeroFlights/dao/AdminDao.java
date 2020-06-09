package com.infy.aeroFlights.dao;

import java.util.List;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;

public interface AdminDao {

	public List<BookingDTO> viewBookings();
	
	public void acceptbookingRequest(Integer bookingId);

	public void rejectBookingRequest(Integer bookingId);
	
	public List<OfferDTO> viewOffers();
	
	public void createFlight(FlightDTO flight);
	
	public void addOffer(OfferDTO offer);
	
	public void removeOffer(String offertitle);
	
}
