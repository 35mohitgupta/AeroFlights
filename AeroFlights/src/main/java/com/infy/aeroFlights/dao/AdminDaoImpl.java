package com.infy.aeroFlights.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.infy.aeroFlights.entity.BookingEntity;
import com.infy.aeroFlights.model.Booking;
import com.infy.aeroFlights.model.Flight;
import com.infy.aeroFlights.model.Offer;

@Repository(value = "AdminDao")
public class AdminDaoImpl implements AdminDao{

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

	@Override
	public void acceptbookingRequest(Integer bookingId) {
		// TODO Auto-generated method stub
		String sqlQuery = "UPDATE BookingEntity b SET b.bookingStatus='ACCEPTED' WHERE b.bookingId=:bookingId";
		Query query = entityManager.createQuery(sqlQuery);
		query.setParameter("bookingId", bookingId);
		query.executeUpdate();
	}

	@Override
	public void rejectBookingRequest(Integer bookingId) {
		// TODO Auto-generated method stub
		String sqlQuery = "UPDATE BookingEntity b SET b.bookingStatus='REJECTED' WHERE b.bookingId=:bookingId";
		Query query = entityManager.createQuery(sqlQuery);
		query.setParameter("bookingId", bookingId);
		query.executeUpdate();
	}

	
	
}
