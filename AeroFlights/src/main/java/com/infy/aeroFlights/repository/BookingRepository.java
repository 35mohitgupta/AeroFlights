package com.infy.aeroFlights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.aeroFlights.dto.BookingStatus;
import com.infy.aeroFlights.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking	, Integer>{

	List<Booking> findByBookingStatusIn(BookingStatus... bookingStatus);
}
