package com.infy.aeroFlights.service;

import java.util.List;

import com.infy.aeroFlights.dto.BookingDTO;

public interface UserService {

	public List<BookingDTO> viewBooking(String username);
	
	public void cancelBooking(Integer bookingId);
	
	public Integer addBooking(BookingDTO bookingDTO);
	
}
