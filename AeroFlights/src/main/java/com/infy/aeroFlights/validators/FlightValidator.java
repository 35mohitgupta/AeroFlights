package com.infy.aeroFlights.validators;

import java.time.LocalDateTime;

import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.exception.FlightException;

public class FlightValidator {

	public static void validateFlight(FlightDTO flight) throws FlightException {
		validateFlightArrival(flight.getArrival());
		validateFlightDeparture(flight.getDeparture());
		validateFlightSource(flight.getSource());
		validateFlightDestination(flight.getDestination());
		validateFlightNo(flight.getFlightNo());
		validateFlightNoOfSeat(flight.getNoOfSeats());
		validateFlightPrice(flight.getPrice());
	}
	
	public static void validateFlightArrival(LocalDateTime arrival) throws FlightException {
		if(arrival == null)
			throw new FlightException("INVALID_FLIGHT_ARRIVAL_TIME");
	}
	
	public static void validateFlightDeparture(LocalDateTime departure) throws FlightException {
		if(departure == null)
			throw new FlightException("INVALID_FLIGHT_DEPARTURE_TIME");
	}
	
	public static void validateFlightSource(String source) throws FlightException {
		if(source == null || source.trim().equalsIgnoreCase(""))
			throw new FlightException("INVALID_FLIGHT_SOURCE");
	}
	
	public static void validateFlightDestination(String destination) throws FlightException {
		if(destination == null || destination.trim().equalsIgnoreCase(""))
			throw new FlightException("INVALID_FLIGHT_DESTINATION");
	}
	
	public static void validateFlightNo(String flightNo) throws FlightException {
		if(flightNo == null || flightNo.trim().equalsIgnoreCase(""))
			throw new FlightException("INVALID_FLIGHT_NUMBER");
	}
	
	public static void validateFlightNoOfSeat(Integer noOfSeats) throws FlightException {
		if(noOfSeats == null || noOfSeats<=0)
			throw new FlightException("INVALID_FLIGHT_NO_OF_SEATS");
	}
	
	public static void validateFlightPrice(Double price) throws FlightException {
		if(price == null || price <= 0)
			throw new FlightException("INVALID_FLIGHT_PRICE");
	}
	
}
