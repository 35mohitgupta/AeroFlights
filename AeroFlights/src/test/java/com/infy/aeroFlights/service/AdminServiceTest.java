package com.infy.aeroFlights.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import com.infy.aeroFlights.repository.BookingRepository;
import com.infy.aeroFlights.repository.FlightRepository;
import com.infy.aeroFlights.repository.OfferRepository;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.any;
import java.util.Optional;


@RunWith(SpringRunner.class)
public class AdminServiceTest {

	@Mock
	private BookingRepository bookingRepository;
	
	@Mock
	private OfferRepository offerRepository;
	
	@Mock
	private FlightRepository flightRepository;
	
	@InjectMocks
	private AdminService adminService = new AdminServiceImpl();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testViewBookings(){
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
		
		Mockito.when(bookingRepository.findByBookingStatusIn(BookingStatus.ACCEPTED,BookingStatus.REJECTED,BookingStatus.REQUESTED)).thenReturn(bookingList);
		List<BookingDTO> actualBookingDTOs = adminService.viewBookings();
		Assert.assertEquals(bookDtos, actualBookingDTOs);
	}
	
	@Test
	public void testAcceptbookingRequest1() throws BookingException {
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("NO_BOOKING_EXISTS_WITH_THIS_BOOKING_ID");
		Mockito.when(bookingRepository.findById(anyInt())).thenReturn(Optional.empty());
		adminService.acceptbookingRequest(23);
	}

	@Test
	public void testAcceptbookingRequest2() throws BookingException {
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
		adminService.acceptbookingRequest(11);
	}

	@Test
	public void testRejectBookingRequest1()  throws BookingException{
		expectedException.expect(BookingException.class);
		expectedException.expectMessage("NO_BOOKING_EXISTS_WITH_THIS_BOOKING_ID");
		Mockito.when(bookingRepository.findById(anyInt())).thenReturn(Optional.empty());
		adminService.rejectBookingRequest(23);
	}
	
	@Test
	public void testRejectBookingRequest2()  throws BookingException{
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
		adminService.rejectBookingRequest(11);
	}
	
	@Test
	public void testViewOffers() {
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		OfferDTO offerDTO = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		
		Offer offerApplied2 = new Offer("FLY100", 10.0, OfferStatus.INACTIVE);
		OfferDTO offerDTO2 = new OfferDTO("FLY100", 10.0, OfferStatus.INACTIVE);
		
		List<Offer> offerList = new ArrayList<Offer>();
		offerList.add(offerApplied);
		offerList.add(offerApplied2);
		
		List<OfferDTO> offerDtos = new ArrayList<OfferDTO>();
		offerDtos.add(offerDTO);
		offerDtos.add(offerDTO2);
		
		Mockito.when(offerRepository.findAll()).thenReturn(offerList);
		List<OfferDTO> actualOfferDTOs = adminService.viewOffers();
		Assert.assertEquals(offerDtos, actualOfferDTOs);
	}
	
	@Test
	public void testCreateFlight1() throws FlightException {
		expectedException.expect(FlightException.class);
		expectedException.expectMessage("ARRIVAL_TIME_SHOULD_BE_AFTER_DEPARTURE_TIME");
		FlightDTO flight = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 4, 6, 30), 200, 1000.0);
		adminService.createFlight(flight);
	}
	
	@Test
	public void testCreateFlight2() throws FlightException {
		FlightDTO flight = new FlightDTO("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 12, 6, 30), 200, 1000.0);
		adminService.createFlight(flight);
	}
	
	@Test
	public void testAddOffer1() throws OfferException {
		expectedException.expect(OfferException.class);
		expectedException.expectMessage("OFFER_ALREADY_EXISTS");
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		OfferDTO offerApplied2 = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		Mockito.when(offerRepository.findById("FLY120")).thenReturn(Optional.of(offerApplied));
		adminService.addOffer(offerApplied2);
	}
	
	@Test
	public void testAddOffer2() throws OfferException {
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.INACTIVE);
		OfferDTO offerApplied2 = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		Mockito.when(offerRepository.findById("FLY120")).thenReturn(Optional.of(offerApplied));
		adminService.addOffer(offerApplied2);
	}
	
	@Test
	public void testAddOffer3() throws OfferException {
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.INACTIVE);
		OfferDTO offerApplied2 = new OfferDTO("FLY120", 15.0, OfferStatus.ACTIVE);
		Mockito.when(offerRepository.findById("FLY120")).thenReturn(Optional.empty());
		Mockito.when(offerRepository.saveAndFlush(offerApplied)).thenReturn(offerApplied);
		adminService.addOffer(offerApplied2);
	}
	
	@Test
	public void testRemoveOffer1() throws OfferException {
		expectedException.expect(OfferException.class);
		expectedException.expectMessage("NO_OFFER_EXISTS_WITH_THIS_OFFER_TITLE");
		Mockito.when(offerRepository.findById("FLY120")).thenReturn(Optional.empty());
		adminService.removeOffer("FLY120");
	}
	
	@Test
	public void testRemoveOffer2() throws OfferException {
		expectedException.expect(OfferException.class);
		expectedException.expectMessage("NO_ACTIVE_OFFER_WITH_THIS_OFFER_TITLE");
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.INACTIVE);
		Mockito.when(offerRepository.findById("FLY120")).thenReturn(Optional.of(offerApplied));
		adminService.removeOffer("FLY120");
	}
	
	@Test
	public void testRemoveOffer3() throws OfferException {
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		Mockito.when(offerRepository.findById("FLY120")).thenReturn(Optional.of(offerApplied));
		adminService.removeOffer("FLY120");
	}
	
	@Test
	public void testNoOfRequestsPending() {
		Mockito.when(bookingRepository.findNoOfRequests(BookingStatus.REQUESTED)).thenReturn(2);
		Assert.assertEquals(new Integer(2), adminService.noOfRequestsPending());
	}
}
