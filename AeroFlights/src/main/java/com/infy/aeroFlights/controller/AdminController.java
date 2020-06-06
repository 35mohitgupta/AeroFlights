package com.infy.aeroFlights.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.aeroFlights.model.Booking;
import com.infy.aeroFlights.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/view-requests")
	public List<Booking> viewRequests() {
		List<Booking> bookingRequests = adminService.viewBookings();
		return bookingRequests;
	}
	
	@PostMapping("/accept-request/{bookingId}")
	public String acceptRequest(@PathVariable("bookingId") Integer bookingId) {
		adminService.acceptbookingRequest(bookingId);
		return "Flight request with BookingId: "+bookingId+" is ACCEPTED";
	}
	
	@PostMapping("/reject-request/{bookingId}")
	public String rejectRequest(@PathVariable("bookingId") Integer bookingId) {
		adminService.rejectBookingRequest(bookingId);
		return "Flight request with BookingId: "+bookingId+" is REJECTED";
	}
}
