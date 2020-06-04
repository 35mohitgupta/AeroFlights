package com.infy.aeroFlights.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="booking")
public class BookingEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private Integer bookingId;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="username")
	private UserEntity user;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="flight_no")
	private FlightEntity flight;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="offer_title")
	private OfferEntity offerApplied;
	
	@Column(name="no_of_tickets")
	private Integer noOfTickets;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private List<PassengerEntity> passengerList;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public FlightEntity getFlight() {
		return flight;
	}

	public void setFlight(FlightEntity flight) {
		this.flight = flight;
	}

	public OfferEntity getOfferApplied() {
		return offerApplied;
	}

	public void setOfferApplied(OfferEntity offerApplied) {
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

	public List<PassengerEntity> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<PassengerEntity> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
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
		BookingEntity other = (BookingEntity) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
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

		
}
