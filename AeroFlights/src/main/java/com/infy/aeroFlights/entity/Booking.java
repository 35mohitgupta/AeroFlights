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
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private Integer bookingId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="username")
	private String username;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="flight_no")
	private String flightNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="offer_title")
	private String offerApplied;
	
	@Column(name="no_of_tickets")
	private Integer noOfTickets;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private List<Passenger> passengerList;
	
	
}
