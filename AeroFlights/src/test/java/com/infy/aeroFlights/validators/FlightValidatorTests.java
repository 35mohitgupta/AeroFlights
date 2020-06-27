package com.infy.aeroFlights.validators;

import java.time.LocalDateTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.exception.FlightException;

@RunWith(SpringRunner.class)
public class FlightValidatorTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testValidateFlight() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("ARRIVAL_TIME_SHOULD_BE_AFTER_DEPARTURE_TIME");
		FlightDTO flightDTO = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 5, 6, 30), 200, 1000.0);
		FlightValidator.validateFlight(flightDTO);
	}
	
	@Test
	public void testValidateFlightArrval() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_FLIGHT_ARRIVAL_TIME");
		FlightValidator.validateFlightArrival(null);
	}
	
	@Test
	public void testVvalidateFlightDeparture() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_FLIGHT_DEPARTURE_TIME");
		FlightValidator.validateFlightDeparture(null);
	}
	
	@Test
	public void testValidateFlightSource() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_FLIGHT_SOURCE");
		FlightValidator.validateFlightSource("        ");
	}
	
	@Test
	public void testValidateFlightDestination() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_FLIGHT_DESTINATION");
		FlightValidator.validateFlightDestination("        ");
	}
	
	@Test
	public void testValidateFlightNo() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_FLIGHT_NUMBER");
		FlightValidator.validateFlightNo("               ");
	}
	
	@Test
	public void testValidateFlightNoOfSeat() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_FLIGHT_NO_OF_SEATS");
		FlightValidator.validateFlightNoOfSeat(0);
	}
	
	@Test
	public void testValidateFlightPrice() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_FLIGHT_PRICE");
		FlightValidator.validateFlightPrice(0.0);
	}
	
	@Test
	public void testSourceDestinationCheck() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("FLIGHT_SOURCE_AND_DESTINATION_CANNOT_BE_SAME");
		FlightValidator.sourceDestinationCheck("BOM", "BOM");
	}
	
	@Test
	public void testArrivalDepartureCheck() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("ARRIVAL_TIME_SHOULD_BE_AFTER_DEPARTURE_TIME");
		FlightValidator.arrivalDepartureCheck(LocalDateTime.of(2020, 2, 2, 2, 2), LocalDateTime.of(2020 , 2, 1, 1, 1));
		
	}
	
}
