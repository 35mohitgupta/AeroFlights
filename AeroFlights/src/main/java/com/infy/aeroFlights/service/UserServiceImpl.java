package com.infy.aeroFlights.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.entity.Booking;
import com.infy.aeroFlights.entity.Passenger;
import com.infy.aeroFlights.repository.BookingRepository;
import com.infy.aeroFlights.repository.PassengerRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Override
	public List<BookingDTO> viewBooking(String username) {
		List<Booking> bookingEntities = bookingRepository.findByUsername(username);
		List<BookingDTO> bookingDTOs = new ArrayList<BookingDTO>();
		for(Booking bookingEntity: bookingEntities) {
			bookingDTOs.add(BookingDTO.toModel(bookingEntity));
		}
		return bookingDTOs;
	}

	@Override
	public void cancelBooking(Integer bookingId) {
		Optional<Booking> bookOptional = bookingRepository.findById(bookingId);
		if(bookOptional.isPresent()) {
			Booking booking = bookOptional.get();
			booking.setBookingStatus(BookingStatus.CANCELLED);
			bookingRepository.saveAndFlush(booking);
		}
		
	}

	@Override
	public Integer addBooking(BookingDTO bookingDTO) {
		Booking booking = bookingDTO.toEntity();
//		for(Passenger passenger: booking.getPassengerList()) {
//			passengerRepository.save(passenger);
//		}
		bookingRepository.saveAndFlush(booking);
		return booking.getBookingId();
	}

}
