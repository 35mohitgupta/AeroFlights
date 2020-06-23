package com.infy.aeroFlights.repository;

import static org.hamcrest.CoreMatchers.hasItems;


import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.entity.Flight;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightRepositoryTest {

	@Autowired
	private FlightRepository flightRepository;
	
	@Test
	public void testFindBySourceDestinationAndDeparture() {
		Flight flight = new Flight("GO121", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 11, 6, 30), LocalDateTime.of(2020, 6, 11, 15, 6, 30), 200, 1000.0);
		flight = flightRepository.saveAndFlush(flight);
		Flight flight2 = new Flight("GO123", "BOM", "AUG", LocalDateTime.of(2020, 6, 11, 4, 6, 30), LocalDateTime.of(2020, 6, 11, 6, 6, 30), 200, 2000.0);
		flight2 = flightRepository.saveAndFlush(flight2);
		
		List<Flight> flightBySourceDestinationDate = flightRepository.findBySourceDestinationAndDeparture("BOM", "AUG", LocalDateTime.of(2020, 6, 11, 0, 1, 0), LocalDateTime.of(2020, 6, 11, 23, 59, 59));
		Assert.assertThat(flightBySourceDestinationDate, hasItems(flight,flight2));
		
	}
}
