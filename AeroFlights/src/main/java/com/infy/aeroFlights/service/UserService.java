package com.infy.aeroFlights.service;

import java.time.LocalDate;
import java.util.List;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;
import com.infy.aeroFlights.exception.PassengerException;
import com.infy.aeroFlights.exception.UserException;

public interface UserService {

	public List<BookingDTO> viewBooking(String username) throws UserException;
	
	public void cancelBooking(Integer bookingId) throws BookingException;
	
	public Integer addBooking(BookingDTO bookingDTO) throws FlightException, BookingException, OfferException, PassengerException, UserException ;
	
	public List<FlightDTO> getFlightsFromToOn(String from, String to, LocalDate date) throws FlightException;
	
	public List<OfferDTO> getCurrentOffer();
	
	public Integer getNoOfBookingsRequested(String username);
	
}
