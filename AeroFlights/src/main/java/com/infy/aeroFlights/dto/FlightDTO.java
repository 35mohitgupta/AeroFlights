package com.infy.aeroFlights.dto;

import java.time.LocalDateTime;

import com.infy.aeroFlights.entity.Flight;

public class FlightDTO {

	private String flightNo;
	
	private String source;
	
	private String destination;
	
	private LocalDateTime departure;
	
	private LocalDateTime arrival;
	
	private Integer noOfSeats;
	
	private Double price;

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
		FlightDTO other = (FlightDTO) obj;
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

	public Flight toEntity() {
		Flight flightEntity = new Flight();
		flightEntity.setArrival(arrival);
		flightEntity.setDeparture(departure);
		flightEntity.setDestination(destination);
		flightEntity.setFlightNo(flightNo);
		flightEntity.setNoOfSeats(noOfSeats);
		flightEntity.setPrice(price);
		flightEntity.setSource(source);
		return flightEntity;
	}

	public static FlightDTO toModel(Flight flightEntity) {
		FlightDTO flight = new FlightDTO();
		flight.arrival = flightEntity.getArrival();
		flight.departure = flightEntity.getDeparture();
		flight.destination = flightEntity.getDestination();
		flight.flightNo = flightEntity.getFlightNo();
		flight.noOfSeats = flightEntity.getNoOfSeats();
		flight.price = flightEntity.getPrice();
		flight.source= flightEntity.getSource();
		return flight;
	}
	
}
