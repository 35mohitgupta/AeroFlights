package com.infy.aeroFlights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.aeroFlights.dto.BookingDTO;
import com.infy.aeroFlights.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(path = "/user/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(path="view-bookings/{username}")
	public ResponseEntity<List<BookingDTO>> viewBookings(@PathVariable(name = "username") String username){
		return new ResponseEntity<List<BookingDTO>>(userService.viewBooking(username), HttpStatus.OK);
	}
	
	@PutMapping(path = "cancel-booking/{bookingId}")
	public ResponseEntity<String> cancelBookings(@PathVariable(name = "bookingId") Integer bookingId){
		userService.cancelBooking(bookingId);
		return new ResponseEntity<String>("Booking with id- "+bookingId+" is cancelled", HttpStatus.OK);
	}
	
	@PostMapping(path = "new-booking")
	public ResponseEntity<String> newBookings(@RequestBody BookingDTO bookingDTO){
		System.out.println(">>>>>new booking");
		Integer bookingId = userService.addBooking(bookingDTO);
		return new ResponseEntity<String>("New Booking is created with id- "+bookingId, HttpStatus.OK);
	}
	
}
