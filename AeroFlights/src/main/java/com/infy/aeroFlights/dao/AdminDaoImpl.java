package com.infy.aeroFlights.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.infy.aeroFlights.entity.BookingEntity;
import com.infy.aeroFlights.model.Booking;
import com.infy.aeroFlights.model.Flight;
import com.infy.aeroFlights.model.Offer;

@Repository(value = "AdminDao")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Booking> viewBookings() {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT b FROM BookingEntity b WHERE b.bookingStatus = 'REQUESTED'";
		Query query = entityManager.createQuery(sqlQuery);
		List<BookingEntity> bookingEntities = query.getResultList();
		List<Booking> bookingRequests = new ArrayList<Booking>();
		for(BookingEntity bookingEntity: bookingEntities) {
			bookingRequests.add(Booking.toModel(bookingEntity));
		}
		return bookingRequests;
	}

	@Override
	public List<Offer> viewOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOffer(Offer offer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOffer(String offertitle) {
		// TODO Auto-generated method stub
		
	}

	
	
}
