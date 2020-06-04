package com.infy.aeroFlights.dao;

import java.util.ArrayList;

import com.infy.aeroFlights.model.Booking;
import com.infy.aeroFlights.model.Flight;
import com.infy.aeroFlights.model.Offer;

public interface AdminDao {

public ArrayList<Booking> viewBookings();
	
	public ArrayList<Offer> viewOffers();
	
	public void createFlight(Flight flight);
	
	public void addOffer(Offer offer);
	
	public void removeOffer(String offertitle);
	
}
