package com.infy.aeroFlights.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;
import com.infy.aeroFlights.exception.PassengerException;
import com.infy.aeroFlights.exception.UserException;

@RestControllerAdvice
public class AeroFlightControllerAdvice {

	@ExceptionHandler(value = OfferException.class)
	public ResponseEntity<String> handleOfferException(OfferException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<String> handleUserException(UserException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = BookingException.class)
	public ResponseEntity<String> handleBookingException(BookingException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = FlightException.class)
	public ResponseEntity<String> handleFlightException(FlightException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = PassengerException.class)
	public ResponseEntity<String> handlePassengerException(PassengerException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
