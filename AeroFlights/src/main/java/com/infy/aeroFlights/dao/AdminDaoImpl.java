package com.infy.aeroFlights.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.entity.Booking;
import com.infy.aeroFlights.repository.BookingRepository;

@Repository(value = "AdminDao")
public class AdminDaoImpl implements AdminDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<BookingDTO> viewBookings() {
		// TODO Auto-generated method stub
//		String sqlQuery = "SELECT b FROM Booking b WHERE b.bookingStatus = 'REQUESTED'";
//		Query query = entityManager.createQuery(sqlQuery);
//		List<Booking> bookingEntities = query.getResultList();
		List<Booking> bookingEntities = bookingRepository.findByBookingStatusIn(BookingStatus.ACCEPTED,BookingStatus.REJECTED,BookingStatus.REQUESTED);
		List<BookingDTO> bookingRequests = new ArrayList<BookingDTO>();
		for(Booking bookingEntity: bookingEntities) {
			bookingRequests.add(BookingDTO.toModel(bookingEntity));
		}

		return bookingRequests;
	}

	@Override
	public List<OfferDTO> viewOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFlight(FlightDTO flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOffer(OfferDTO offer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOffer(String offertitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptbookingRequest(Integer bookingId) {
		// TODO Auto-generated method stub
		String sqlQuery = "UPDATE Booking b SET b.bookingStatus='ACCEPTED' WHERE b.bookingId=:bookingId";
		Query query = entityManager.createQuery(sqlQuery);
		query.setParameter("bookingId", bookingId);
		query.executeUpdate();
	}

	@Override
	public void rejectBookingRequest(Integer bookingId) {
		// TODO Auto-generated method stub
		String sqlQuery = "UPDATE Booking b SET b.bookingStatus='REJECTED' WHERE b.bookingId=:bookingId";
		Query query = entityManager.createQuery(sqlQuery);
		query.setParameter("bookingId", bookingId);
		query.executeUpdate();
	}

	
	
}
