package com.infy.aeroFlights.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.aeroFlights.model.Booking;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/viewBooking")
	public ResponseEntity<ArrayList<Booking>> viewRequests() {
		ResponseEntity<ArrayList<Booking>> bookings = null;
		return null;
	}
}
