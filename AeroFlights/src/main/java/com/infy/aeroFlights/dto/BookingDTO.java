package com.infy.aeroFlights.dto;

import java.util.ArrayList;
import java.util.List;
import com.infy.aeroFlights.entity.Booking;
import com.infy.aeroFlights.entity.Passenger;

public class BookingDTO {

	private Integer bookingId;
	
	private UserDTO user;

	private FlightDTO flight;

	private OfferDTO offerApplied;
	
	private Integer noOfTickets;

	private Double totalAmount;
	
	private List<PassengerDTO> passengerList;
	
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
		BookingDTO other = (BookingDTO) obj;
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public OfferDTO getOfferApplied() {
		return offerApplied;
	}

	public void setOfferApplied(OfferDTO offerApplied) {
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

	public List<PassengerDTO> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<PassengerDTO> passengerList) {
		this.passengerList = passengerList;
	}

	public Booking toEntity() {
		Booking bookingEntity = new Booking();
		bookingEntity.setBookingId(bookingId);		
		bookingEntity.setFlight(flight.toEntity());
		bookingEntity.setNoOfTickets(noOfTickets);
		bookingEntity.setOfferApplied(offerApplied.toEntity());
		
		ArrayList<Passenger> passengerEntities = new ArrayList<Passenger>();
		for(PassengerDTO passenger: passengerList) {
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
	
	public static BookingDTO toModel(Booking bookingEntity) {
		BookingDTO booking = new BookingDTO();
		booking.bookingId = bookingEntity.getBookingId();
		booking.flight = FlightDTO.toModel(bookingEntity.getFlight());
		booking.noOfTickets = bookingEntity.getNoOfTickets();
		booking.offerApplied = OfferDTO.toModel(bookingEntity.getOfferApplied());
		
		ArrayList<PassengerDTO> passengers = new ArrayList<PassengerDTO>();
		for(Passenger passengerEntity: bookingEntity.getPassengerList()) {
			passengers.add(PassengerDTO.toModel(passengerEntity));
		}
		booking.passengerList = passengers;
		booking.totalAmount = bookingEntity.getTotalAmount();
		booking.user = UserDTO.toModel(bookingEntity.getUser());
		booking.bookingStatus = bookingEntity.getBookingStatus();
		return booking;
	}

}
