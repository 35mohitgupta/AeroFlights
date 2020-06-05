package com.infy.aeroFlights.model;

import java.util.ArrayList;
import java.util.List;
import com.infy.aeroFlights.entity.BookingEntity;
import com.infy.aeroFlights.entity.PassengerEntity;

public class Booking {

	private Integer bookingId;
	
	private User user;

	private Flight flight;

	private Offer offerApplied;
	
	private Integer noOfTickets;

	private Double totalAmount;
	
	private List<Passenger> passengerList;
	
	private BookingStatus bookingStatus;
	
	
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((bookingStatus == null) ? 0 : bookingStatus.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((noOfTickets == null) ? 0 : noOfTickets.hashCode());
		result = prime * result + ((offerApplied == null) ? 0 : offerApplied.hashCode());
		result = prime * result + ((passengerList == null) ? 0 : passengerList.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (bookingStatus != other.bookingStatus)
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (noOfTickets == null) {
			if (other.noOfTickets != null)
				return false;
		} else if (!noOfTickets.equals(other.noOfTickets))
			return false;
		if (offerApplied == null) {
			if (other.offerApplied != null)
				return false;
		} else if (!offerApplied.equals(other.offerApplied))
			return false;
		if (passengerList == null) {
			if (other.passengerList != null)
				return false;
		} else if (!passengerList.equals(other.passengerList))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Offer getOfferApplied() {
		return offerApplied;
	}

	public void setOfferApplied(Offer offerApplied) {
		this.offerApplied = offerApplied;
	}

	public Integer getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(Integer noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public BookingEntity toEntity() {
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setBookingId(bookingId);		
		bookingEntity.setFlight(flight.toEntity());
		bookingEntity.setNoOfTickets(noOfTickets);
		bookingEntity.setOfferApplied(offerApplied.toEntity());
		
		ArrayList<PassengerEntity> passengerEntities = new ArrayList<PassengerEntity>();
		for(Passenger passenger: passengerList) {
			passengerEntities.add(passenger.toEntity());
		}
		
//		passengerList.stream().map( passenger -> {
//			return passenger.toEntity();
//		}).toArray();
		
		bookingEntity.setPassengerList(passengerEntities);
		bookingEntity.setTotalAmount(totalAmount);
		bookingEntity.setUser(user.toEntity());
		bookingEntity.setBookingStatus(bookingStatus);
		return bookingEntity;
	}
	
	public static Booking toModel(BookingEntity bookingEntity) {
		Booking booking = new Booking();
		booking.bookingId = bookingEntity.getBookingId();
		booking.flight = Flight.toModel(bookingEntity.getFlight());
		booking.noOfTickets = bookingEntity.getNoOfTickets();
		booking.offerApplied = Offer.toModel(bookingEntity.getOfferApplied());
		
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		for(PassengerEntity passengerEntity: bookingEntity.getPassengerList()) {
			passengers.add(Passenger.toModel(passengerEntity));
		}
		booking.passengerList = passengers;
		booking.totalAmount = bookingEntity.getTotalAmount();
		booking.user = User.toModel(bookingEntity.getUser());
		booking.bookingStatus = bookingEntity.getBookingStatus();
		return booking;
	}

}
