package com.infy.aeroFlights.service;

import static org.mockito.ArgumentMatchers.anyInt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.Gender;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.dto.PassengerDTO;
import com.infy.aeroFlights.dto.UserDTO;
import com.infy.aeroFlights.entity.Booking;
import com.infy.aeroFlights.entity.Flight;
import com.infy.aeroFlights.entity.Offer;
import com.infy.aeroFlights.entity.Passenger;
import com.infy.aeroFlights.entity.User;
import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;
import com.infy.aeroFlights.exception.PassengerException;
import com.infy.aeroFlights.exception.UserException;
import com.infy.aeroFlights.repository.BookingRepository;
import com.infy.aeroFlights.repository.FlightRepository;
import com.infy.aeroFlights.repository.OfferRepository;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Mock
	private FlightRepository flightRepository;
	
	@Mock
	private BookingRepository bookingRepository;
	
	@Mock
	private OfferRepository offerRepository;
	
	@InjectMocks
	private UserService userService = new UserServiceImpl();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testViewBooking() throws UserException {
		User user = new User("John", "John123@gmail.com", "john@123","9876543210");
		UserDTO userDTO = new UserDTO("John", "John123@gmail.com", "john@123","9876543210");
		
		Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		FlightDTO flightDTO = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		
		Passenger passenger = new Passenger(121, "John", 33, Gender.MALE);
		PassengerDTO passengerDTO = new PassengerDTO(121, "John", 33, Gender.MALE);
		Passenger passenger2 = new Passenger(122, "Jonny", 33, Gender.FEMALE);
		PassengerDTO passengerDTO2 = new PassengerDTO(122, "Jonny", 33, Gender.FEMALE);
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(passenger);
		passengers.add(passenger2);
		List<PassengerDTO> passengerDTOs = new ArrayList<PassengerDTO>();
		passengerDTOs.add(passengerDTO);
		passengerDTOs.add(passengerDTO2);
		
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		OfferDTO offerDTO = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		
		Booking booking = new Booking(11, user, flight, offerApplied, 2, 1500.0, passengers, BookingStatus.REQUESTED);
		List<Booking> bookingList = new ArrayList<Booking>();
		bookingList.add(booking);
		BookingDTO bookingDTO = new BookingDTO(11, userDTO, flightDTO, offerDTO, 2, 1500.0, passengerDTOs, BookingStatus.REQUESTED);
		List<BookingDTO> bookDtos = new ArrayList<BookingDTO>();
		bookDtos.add(bookingDTO);
	
		Mockito.when(bookingRepository.findByUsername("John")).thenReturn(bookingList);
		List<BookingDTO> actualBookingDTOs = userService.viewBooking("John");
		Assert.assertEquals(bookDtos, actualBookingDTOs);
	}
	
	@Test
	public void testCancelBooking1() throws BookingException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("NO_BOOKING_EXISTS_WITH_THIS_BOOKING_ID");
		Mockito.when(bookingRepository.findById(anyInt())).thenReturn(Optional.empty());
		userService.cancelBooking(121);
	}
	
	@Test
	public void testCancelBooking2() throws BookingException {
		User user = new User("John", "John123@gmail.com", "john@123","9876543210");
		Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		Passenger passenger = new Passenger(121, "John", 33, Gender.MALE);
		Passenger passenger2 = new Passenger(122, "Jonny", 33, Gender.FEMALE);
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(passenger);
		passengers.add(passenger2);
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		Booking booking = new Booking(11, user, flight, offerApplied, 2, 1500.0, passengers, BookingStatus.REQUESTED);
		Mockito.when(bookingRepository.findById(11)).thenReturn(Optional.of(booking));
		userService.cancelBooking(11);
	}
	
	@Test
	public void testAddBooking() throws FlightException, BookingException, OfferException, PassengerException, UserException {
		User user = new User("John", "John123@gmail.com", "john@123","9876543210");
		UserDTO userDTO = new UserDTO("John", "John123@gmail.com", "john@123","9876543210");
		
		Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		FlightDTO flightDTO = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		
		Passenger passenger = new Passenger(121, "John", 33, Gender.MALE);
		PassengerDTO passengerDTO = new PassengerDTO(121, "John", 33, Gender.MALE);
		Passenger passenger2 = new Passenger(122, "Jonny", 33, Gender.FEMALE);
		PassengerDTO passengerDTO2 = new PassengerDTO(122, "Jonny", 33, Gender.FEMALE);
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(passenger);
		passengers.add(passenger2);
		List<PassengerDTO> passengerDTOs = new ArrayList<PassengerDTO>();
		passengerDTOs.add(passengerDTO);
		passengerDTOs.add(passengerDTO2);
		
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		OfferDTO offerDTO = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		
		Booking booking = new Booking(11, user, flight, offerApplied, 2, 1500.0, passengers, BookingStatus.REQUESTED);
		BookingDTO bookingDTO = new BookingDTO(11, userDTO, flightDTO, offerDTO, 2, 1500.0, passengerDTOs, BookingStatus.REQUESTED);
		
		Mockito.when(bookingRepository.saveAndFlush(booking)).thenReturn(booking);
		Assert.assertEquals(new Integer(11), userService.addBooking(bookingDTO));
	}
	
	@Test
	public void getFlightsFromToOn1() throws FlightException {
		Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		FlightDTO flightDTO = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		
		Flight flight2 = new Flight("FUNGO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 5, 30, 30), LocalDateTime.of(2020, 6, 11, 7, 6, 30), 200, 2000.0);
		FlightDTO flightDTO2 = new FlightDTO("FUNGO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 5, 30, 30), LocalDateTime.of(2020, 6, 11, 7, 6, 30), 200, 2000.0);
		
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(flight);
		flights.add(flight2);
		List<FlightDTO> flightDTOs = new ArrayList<FlightDTO>();
		flightDTOs.add(flightDTO);
		flightDTOs.add(flightDTO2);
		
		Mockito.when(flightRepository.findBySourceDestinationAndDeparture("BOM", "AUG", LocalDateTime.of(2020, 6, 11, 0, 0), LocalDateTime.of(2020, 6, 11, 23, 59))).thenReturn(flights);
		List<FlightDTO> actualDtos = userService.getFlightsFromToOn("BOM", "AUG", LocalDate.of(2020, 6, 11));
		
		Assert.assertEquals(flightDTOs, actualDtos);
	}
	
	@Test
	public void getFlightsFromToOn2() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("INVALID_DATE");
		userService.getFlightsFromToOn("BOM", "AUG", null);
	}
	
	@Test
	public void getCurrentOffer() {
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		OfferDTO offerDTO = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		Offer offerApplied2 = new Offer("FLY100", 10.0, OfferStatus.INACTIVE);
		OfferDTO offerDTO2 = new OfferDTO("FLY100", 10.0, OfferStatus.INACTIVE);
		Offer offerApplied3 = new Offer("FLY200", 20.0, OfferStatus.ACTIVE);
		OfferDTO offerDTO3 = new OfferDTO("FLY200", 20.0, OfferStatus.ACTIVE);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(offerApplied);
		offers.add(offerApplied3);
		List<OfferDTO> offerDTOs = new ArrayList<OfferDTO>();
		offerDTOs.add(offerDTO);
		offerDTOs.add(offerDTO3);
		Mockito.when(offerRepository.findByStatus(OfferStatus.ACTIVE)).thenReturn(offers);
		Assert.assertEquals(offerDTOs, userService.getCurrentOffer());
		
	}
	
	@Test
	public void getNoOfBookingsRequested() {
		Mockito.when(bookingRepository.findNoOfBookingsForUser("John", BookingStatus.REQUESTED)).thenReturn(2);
		Assert.assertEquals(new Integer(2), userService.getNoOfBookingsRequested("John"));
	}
	
}
