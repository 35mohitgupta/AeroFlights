package com.infy.aeroFlights.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.entity.Booking;
import com.infy.aeroFlights.entity.Flight;
import com.infy.aeroFlights.entity.Offer;
import com.infy.aeroFlights.repository.BookingRepository;
import com.infy.aeroFlights.repository.FlightRepository;
import com.infy.aeroFlights.repository.OfferRepository;

@Transactional
@Service(value = "AdminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private BookingRepository bookingRpository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private OfferRepository offerRepository;
	
	@Override
	public List<BookingDTO> viewBookings() {
		
		List<Booking> bookingEntities = bookingRpository.findByBookingStatusIn(BookingStatus.ACCEPTED,BookingStatus.REJECTED,BookingStatus.REQUESTED);
		List<BookingDTO> bookingRequests = new ArrayList<BookingDTO>();
		for(Booking bookingEntity: bookingEntities) {
			bookingRequests.add(BookingDTO.toModel(bookingEntity));
		}
		return bookingRequests;
	}

	@Override
	public List<OfferDTO> viewOffers() {
		List<Offer> offerEntity = offerRepository.findAll();
		List<OfferDTO> offers = new ArrayList<OfferDTO>();
		for(Offer offer: offerEntity) {
			offers.add(OfferDTO.toModel(offer));
		}
		return offers;
	}

	@Override
	public void createFlight(FlightDTO flight) {
		Flight flightEntity = flight.toEntity();
		flightRepository.saveAndFlush(flightEntity);
	}

	@Override
	public void addOffer(OfferDTO offer) throws Exception {
		Optional<Offer> existingOfferOptional = offerRepository.findById(offer.getOfferTitle());
		if(existingOfferOptional.isPresent()) {
			Offer offerEntity = existingOfferOptional.get();
			if(offerEntity.getStatus() == OfferStatus.ACTIVE)
				throw new Exception("Offer Already Exists");
			offerEntity.setDiscount(offer.getDiscount());
			offerEntity.setStatus(OfferStatus.ACTIVE);
		}else {
			Offer offerEntity = offer.toEntity();
			offerRepository.saveAndFlush(offerEntity);
		}
	}

	@Override
	public void removeOffer(String offerTitle) {
		Optional<Offer> offerOptional = offerRepository.findById(offerTitle);
		if(offerOptional.isPresent()) {
			Offer offer = offerOptional.get();
			offer.setStatus(OfferStatus.INACTIVE);
			offerRepository.saveAndFlush(offer);
		}
	}

	@Override
	public void acceptbookingRequest(Integer bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> bookingOptional = bookingRpository.findById(bookingId);
		if(bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();
			booking.setBookingStatus(BookingStatus.ACCEPTED);
			bookingRpository.saveAndFlush(booking);
		}
	}

	@Override
	public void rejectBookingRequest(Integer bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> bookingOptional = bookingRpository.findById(bookingId);
		if(bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();
			booking.setBookingStatus(BookingStatus.REJECTED);
			bookingRpository.saveAndFlush(booking);
		}
	}

}
