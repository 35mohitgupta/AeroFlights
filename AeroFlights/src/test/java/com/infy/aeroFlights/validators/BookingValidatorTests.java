package com.infy.aeroFlights.validators;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.Gender;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.dto.PassengerDTO;
import com.infy.aeroFlights.dto.UserDTO;
import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;
import com.infy.aeroFlights.exception.PassengerException;
import com.infy.aeroFlights.exception.UserException;

@RunWith(SpringRunner.class)
public class BookingValidatorTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testValidateBooking() throws FlightException, BookingException, OfferException, PassengerException, UserException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("NO_OF_PASSENGERS_IS_NOT_SAME_AS_PASSENGER");
		UserDTO userDTO = new UserDTO("John", "John123@gmail.com", "john@123","9876543210");
		FlightDTO flightDTO = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		PassengerDTO passengerDTO = new PassengerDTO(121, "John", 33, Gender.MALE);
		PassengerDTO passengerDTO2 = new PassengerDTO(122, "Jonny", 33, Gender.FEMALE);
		List<PassengerDTO> passengerDTOs = new ArrayList<PassengerDTO>();
		passengerDTOs.add(passengerDTO);
		passengerDTOs.add(passengerDTO2);
		OfferDTO offerDTO = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		BookingDTO bookingDTO = new BookingDTO(11, userDTO, flightDTO, offerDTO, 1, 1500.0, passengerDTOs, BookingStatus.REQUESTED);
		BookingValidator.validateBooking(bookingDTO);
	}
	
	@Test
	public void testValidateBookingId() throws FlightException, BookingException, OfferException, PassengerException, UserException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("BOOKING_ID_INVALID");
		BookingValidator.validateBookingId(0);
	}
	
	@Test
	public void testValidateFlight() throws FlightException {
		FlightDTO flightDTO = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		BookingValidator.validateFlight(flightDTO);
	}
	
	@Test
	public void testValidateNoOfPassengers() throws BookingException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("NO_OF_TICKETS_ARE_INVALID");
		BookingValidator.validateNoOfPassengers(0);
	}
	
	@Test
	public void testValidatePassengers1() throws BookingException, PassengerException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("NO_PASSENGER_INFORMATION");
		BookingValidator.validatePassengers(null);
	}
	
	@Test
	public void testValidatePassengers2() throws BookingException, PassengerException {
		List<PassengerDTO> passengerDTOs = new ArrayList<PassengerDTO>();
		PassengerDTO passengerDTO = new PassengerDTO(121, "John", 33, Gender.MALE);
		PassengerDTO passengerDTO2 = new PassengerDTO(122, "Jonny", 33, Gender.FEMALE);
		passengerDTOs.add(passengerDTO);
		passengerDTOs.add(passengerDTO2);
		BookingValidator.validatePassengers(passengerDTOs);
	}
	
	@Test
	public void testValidateOffer() throws OfferException {
		OfferDTO offerDTO = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		BookingValidator.validateOffer(offerDTO);
	}
	
	@Test
	public void testValidateBookingStatus() throws BookingException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("INVALID_BOOKING_STATUS");
		BookingValidator.validateBookingStatus(null);
	}
	
	@Test
	public void testValidateTotalAmount() throws BookingException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("INVALID_TOTAL_PRICE");
		BookingValidator.validateTotalAmount(0.0);
	}
	
	@Test
	public void testValidateUser() throws UserException {
		UserDTO userDTO = new UserDTO("John", "John123@gmail.com", "john@123","9876543210");
		BookingValidator.validateUser(userDTO);
	}
	
	@Test
	public void testValidateNoOfPassengers2() throws BookingException  {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("NO_OF_PASSENGERS_IS_NOT_SAME_AS_PASSENGER");
		List<PassengerDTO> passengerDTOs = new ArrayList<PassengerDTO>();
		PassengerDTO passengerDTO = new PassengerDTO(121, "John", 33, Gender.MALE);
		PassengerDTO passengerDTO2 = new PassengerDTO(122, "Jonny", 33, Gender.FEMALE);
		passengerDTOs.add(passengerDTO);
		passengerDTOs.add(passengerDTO2);
		BookingValidator.validateNoOfPassengers(1, passengerDTOs);
	}
	

}
