package com.infy.aeroFlights.service;

import java.time.LocalDate;
import java.util.List;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;

public interface UserService {

	public List<BookingDTO> viewBooking(String username);
	
	public void cancelBooking(Integer bookingId);
	
	public Integer addBooking(BookingDTO bookingDTO);
	
	public List<FlightDTO> getFlightsFromToOn(String from, String to, LocalDate date);
	
	public List<OfferDTO> getCurrentOffer();
	
}
