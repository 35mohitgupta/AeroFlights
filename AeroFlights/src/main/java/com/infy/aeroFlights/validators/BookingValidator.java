package com.infy.aeroFlights.validators;

import java.util.List;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.dto.PassengerDTO;
import com.infy.aeroFlights.dto.UserDTO;
import com.infy.aeroFlights.entity.Passenger;
import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;
import com.infy.aeroFlights.exception.PassengerException;
import com.infy.aeroFlights.exception.UserException;

public class BookingValidator {

	public static void validateBooking(BookingDTO bookingDTO) throws FlightException, BookingException, OfferException, PassengerException, UserException {
		validateBookingStatus(bookingDTO.getBookingStatus());
		validateFlight(bookingDTO.getFlight());
		validateNoOfPassengers(bookingDTO.getNoOfTickets());
		validateOffer(bookingDTO.getOfferApplied());
		validatePassengers(bookingDTO.getPassengerList());
		validateTotalAmount(bookingDTO.getTotalAmount());
		validateUser(bookingDTO.getUser());
		validateNoOfPassengers(bookingDTO.getNoOfTickets(),bookingDTO.getPassengerList());
	}
	
	public static void validateBookingId(Integer bookingId) throws BookingException {
		if(bookingId == null || bookingId <= 0)
			throw new BookingException("BOOKING_ID_INVALID");
	}
	
	public static void validateFlight(FlightDTO flightDTO) throws FlightException {
		FlightValidator.validateFlight(flightDTO);
	}
	
	public static void validateNoOfPassengers(Integer noOfPassengers) throws BookingException {
		if(noOfPassengers == null || noOfPassengers<=0)
			throw new BookingException("NO_OF_TICKETS_ARE_INVALID");
	}
	
	public static void validatePassengers(List<PassengerDTO> passengers) throws BookingException, PassengerException {
		if(passengers == null || passengers.size() == 0)
			throw new BookingException("NO_PASSENGER_INFORMATION");
		for(PassengerDTO passengerDTO : passengers) {
			PassengerValidation.validatePassenger(passengerDTO);
		}
	}
	
	public static void validateOffer(OfferDTO offer) throws OfferException {
		OfferValidator.validateOffer(offer);
	}
	
	public static void validateBookingStatus(BookingStatus bookingStatus) throws BookingException {
		if(bookingStatus == null)
			throw new BookingException("INVALID_BOOKING_STATUS"); 
	}
	
	public static void validateTotalAmount(Double totalAmount) throws BookingException {
		if(totalAmount == null || totalAmount<=0)
			throw new BookingException("INVALID_TOTAL_PRICE");
	}
	
	public static void validateUser(UserDTO userDto) throws UserException {
		UserValidator.validateUser(userDto);
	}
	
	public static void validateNoOfPassengers(Integer noOfPassenger, List<PassengerDTO> passengerDTOs) throws BookingException {
		if(noOfPassenger != passengerDTOs.size())
			throw new BookingException("NO_OF_PASSENGERS_IS_NOT_SAME_AS_PASSENGER");
	}
	
}
