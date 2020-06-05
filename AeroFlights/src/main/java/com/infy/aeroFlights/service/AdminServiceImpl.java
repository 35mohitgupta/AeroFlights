package com.infy.aeroFlights.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.aeroFlights.dao.AdminDao;
import com.infy.aeroFlights.model.Booking;
import com.infy.aeroFlights.model.Flight;
import com.infy.aeroFlights.model.Offer;

@Transactional
@Service(value = "AdminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public List<Booking> viewBookings() {
		// TODO Auto-generated method stub
		return adminDao.viewBookings();
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
