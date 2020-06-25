package com.infy.aeroFlights.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.entity.Booking;
import com.infy.aeroFlights.entity.Flight;
import com.infy.aeroFlights.entity.Offer;
import com.infy.aeroFlights.entity.Passenger;
import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;
import com.infy.aeroFlights.exception.PassengerException;
import com.infy.aeroFlights.exception.UserException;
import com.infy.aeroFlights.repository.BookingRepository;
import com.infy.aeroFlights.repository.FlightRepository;
import com.infy.aeroFlights.repository.OfferRepository;
import com.infy.aeroFlights.repository.PassengerRepository;
import com.infy.aeroFlights.validators.BookingValidator;
import com.infy.aeroFlights.validators.FlightValidator;
import com.infy.aeroFlights.validators.UserValidator;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private OfferRepository offerRepository;
	
	@Override
	public List<BookingDTO> viewBooking(String username) throws UserException {
		UserValidator.validateUsername(username);
		List<Booking> bookingEntities = bookingRepository.findByUsername(username);
		List<BookingDTO> bookingDTOs = new ArrayList<BookingDTO>();
		for(Booking bookingEntity: bookingEntities) {
			bookingDTOs.add(BookingDTO.toModel(bookingEntity));
		}
		return bookingDTOs;
	}

	@Override
	public void cancelBooking(Integer bookingId) throws BookingException {
		BookingValidator.validateBookingId(bookingId);
		Optional<Booking> bookOptional = bookingRepository.findById(bookingId);
		if(bookOptional.isPresent()) {
			Booking booking = bookOptional.get();
			booking.setBookingStatus(BookingStatus.CANCELLED);
			bookingRepository.saveAndFlush(booking);
		}
		
	}

	@Override
	public Integer addBooking(BookingDTO bookingDTO) throws FlightException, BookingException, OfferException, PassengerException, UserException {
		BookingValidator.validateBooking(bookingDTO);
		Booking booking = bookingDTO.toEntity();
		bookingRepository.saveAndFlush(booking);
		return booking.getBookingId();
	}

	@Override
	public List<FlightDTO> getFlightsFromToOn(String from, String to, LocalDate date) throws FlightException {
		LocalDateTime startTime = LocalDateTime.of(date, LocalTime.of(0, 0, 0));
		LocalDateTime endTime = LocalDateTime.of(date, LocalTime.of(23, 59, 59));
		FlightValidator.validateFlightDestination(to);
		FlightValidator.validateFlightSource(from);
		if(date == null)
			throw new FlightException("INVALID_DATE");
		List<Flight> flightEntities = flightRepository.findBySourceDestinationAndDeparture(from, to, startTime,endTime);
		List<FlightDTO> flightDTOs = new ArrayList<FlightDTO>();
		for(Flight flightEntity: flightEntities) {
			flightDTOs.add(FlightDTO.toModel(flightEntity));
		}
		return flightDTOs;
	}

	@Override
	public List<OfferDTO> getCurrentOffer() {
		List<Offer> offerEntities = offerRepository.findByStatus(OfferStatus.ACTIVE);
		List<OfferDTO> offerDtos = new ArrayList<OfferDTO>();
		for(Offer offerEntity: offerEntities) {
			offerDtos.add(OfferDTO.toModel(offerEntity));
		}
		return offerDtos;
	}

	@Override
	public Integer getNoOfBookingsRequested(String username) {
		return bookingRepository.findNoOfBookingsForUser(username,BookingStatus.REQUESTED);
	}

}
