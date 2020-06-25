package com.infy.aeroFlights.repository;

import static org.hamcrest.CoreMatchers.hasItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.dto.Gender;
import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.entity.Booking;
import com.infy.aeroFlights.entity.Flight;
import com.infy.aeroFlights.entity.Offer;
import com.infy.aeroFlights.entity.Passenger;
import com.infy.aeroFlights.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookingRepositoryTest {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepositoy userRepositoy;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private OfferRepository offerRepository;
	
	@Test
	public void testFindByBookingStatusIn() {
		 User user = new User("John", "John123@gmail.com", "john@123","9876543210");
		 user = userRepositoy.saveAndFlush(user);
		 Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		 flight = flightRepository.saveAndFlush(flight);
		 Passenger passenger = new Passenger(121, "John", 33, Gender.MALE);
		 passenger = passengerRepository.saveAndFlush(passenger);
		 Passenger passenger2 = new Passenger(122, "Jonny", 33, Gender.FEMALE);
		 passenger2 = passengerRepository.saveAndFlush(passenger2);
		 List<Passenger> passengers = new ArrayList<Passenger>();
		 passengers.add(passenger);
		 passengers.add(passenger2);
		 Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		 offerApplied = offerRepository.saveAndFlush(offerApplied);
		 Booking booking = new Booking(11, user, flight, offerApplied, 2, 1500.0, passengers, BookingStatus.REQUESTED);
		 booking = bookingRepository.saveAndFlush(booking);
		 List<Booking> bookingWithRequestStatus = bookingRepository.findByBookingStatusIn(BookingStatus.REQUESTED);
		 Assert.assertThat(bookingWithRequestStatus, hasItem(booking));
	}
	
	@Test
	public void testFindByUsername() {
		 User user = new User("John", "John123@gmail.com", "john@123","9876543210");
		 user = userRepositoy.saveAndFlush(user);
		 Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		 flight = flightRepository.saveAndFlush(flight);
		 Passenger passenger = new Passenger(121, "John", 33, Gender.MALE);
		 passenger = passengerRepository.saveAndFlush(passenger);
		 Passenger passenger2 = new Passenger(122, "Jonny", 33, Gender.FEMALE);
		 passenger2 = passengerRepository.saveAndFlush(passenger2);
		 List<Passenger> passengers = new ArrayList<Passenger>();
		 passengers.add(passenger);
		 passengers.add(passenger2);
		 Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		 offerApplied = offerRepository.saveAndFlush(offerApplied);
		 Booking booking = new Booking(11, user, flight, offerApplied, 2, 1500.0, passengers, BookingStatus.REQUESTED);
		 booking = bookingRepository.saveAndFlush(booking);
		 List<Booking> bookingByUsername = bookingRepository.findByUsername(user.getUsername());
		 Assert.assertThat(bookingByUsername, hasItem(booking));
		
	}
	
	@Test
	public void testFindNoOfRequests() {
		User user = new User("John", "John123@gmail.com", "john@123","9876543210");
		user = userRepositoy.saveAndFlush(user);
		Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		flight = flightRepository.saveAndFlush(flight);
		Passenger passenger = new Passenger(121, "John", 33, Gender.MALE);
		passenger = passengerRepository.saveAndFlush(passenger);
		Passenger passenger2 = new Passenger(122, "Jonny", 33, Gender.FEMALE);
		passenger2 = passengerRepository.saveAndFlush(passenger2);
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(passenger);
		passengers.add(passenger2);
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		offerApplied = offerRepository.saveAndFlush(offerApplied);
		Booking booking = new Booking(11, user, flight, offerApplied, 2, 1500.0, passengers, BookingStatus.REQUESTED);
		booking = bookingRepository.saveAndFlush(booking);
		Integer noOfRequestActual = bookingRepository.findNoOfRequests(BookingStatus.REQUESTED);
		Assert.assertEquals(new Integer(1), noOfRequestActual);
	}
	
	@Test
	public void testFindNoOfBookingsForUser() {
		User user = new User("John", "John123@gmail.com", "john@123","9876543210");
		user = userRepositoy.saveAndFlush(user);
		Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		flight = flightRepository.saveAndFlush(flight);
		Passenger passenger = new Passenger(121, "John", 33, Gender.MALE);
		passenger = passengerRepository.saveAndFlush(passenger);
		Passenger passenger2 = new Passenger(122, "Jonny", 33, Gender.FEMALE);
		passenger2 = passengerRepository.saveAndFlush(passenger2);
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(passenger);
		passengers.add(passenger2);
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		offerApplied = offerRepository.saveAndFlush(offerApplied);
		Booking booking = new Booking(11, user, flight, offerApplied, 2, 1500.0, passengers, BookingStatus.REQUESTED);
		booking = bookingRepository.saveAndFlush(booking);
		Integer noOfBookingsActual = bookingRepository.findNoOfBookingsForUser(user.getUsername(),BookingStatus.REQUESTED);
		Assert.assertEquals(new Integer(1), noOfBookingsActual);
	}
	
}
