package com.infy.aeroFlights.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {

	@Id
	@Column(name="flight_no")
	private String flightNo;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="departure")
	private LocalDateTime departure;
	
	@Column(name="arrival")
	private LocalDateTime arrival;
	
	@Column(name="no_of_seats")
	private Integer noOfSeats;
	
	@Column(name="price")
	private Double price;

	public Flight() {}
	
	public Flight(String flightNo, String source, String destination, LocalDateTime departure, LocalDateTime arrival,
			Integer noOfSeats, Double price) {
		super();
		this.flightNo = flightNo;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.noOfSeats = noOfSeats;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", source=" + source + ", destination=" + destination + ", departure="
				+ departure + ", arrival=" + arrival + ", noOfSeats=" + noOfSeats + ", price=" + price + "]";
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
		result = prime * result + ((noOfSeats == null) ? 0 : noOfSeats.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		Flight other = (Flight) obj;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		if (noOfSeats == null) {
			if (other.noOfSeats != null)
				return false;
		} else if (!noOfSeats.equals(other.noOfSeats))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	
}
