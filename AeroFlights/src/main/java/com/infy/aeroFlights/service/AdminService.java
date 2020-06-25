package com.infy.aeroFlights.service;

import java.util.List;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;

public interface AdminService {

	public List<BookingDTO> viewBookings();
	
	public void acceptbookingRequest(Integer bookingId) throws BookingException;

	public void rejectBookingRequest(Integer bookingId)  throws BookingException;
	
	public List<OfferDTO> viewOffers();
	
	public void createFlight(FlightDTO flight) throws FlightException ;
	
	public void addOffer(OfferDTO offer) throws OfferException;
	
	public void removeOffer(String offerTitle) throws OfferException;
	
	public Integer noOfRequestsPending();
	
}
