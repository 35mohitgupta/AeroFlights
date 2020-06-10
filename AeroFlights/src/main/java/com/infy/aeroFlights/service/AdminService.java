package com.infy.aeroFlights.service;

import java.util.List;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;

public interface AdminService {

	public List<BookingDTO> viewBookings();
	
	public void acceptbookingRequest(Integer bookingId);

	public void rejectBookingRequest(Integer bookingId);
	
	public List<OfferDTO> viewOffers();
	
	public void createFlight(FlightDTO flight);
	
	public void addOffer(OfferDTO offer) throws Exception;
	
	public void removeOffer(String offerTitle);
	
}
