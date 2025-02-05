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
import com.infy.aeroFlights.dto.FlightDTO;
import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.exception.BookingException;
import com.infy.aeroFlights.exception.FlightException;
import com.infy.aeroFlights.exception.OfferException;
import com.infy.aeroFlights.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/view-requests")
	public ResponseEntity<List<BookingDTO>>  viewRequests() {
		List<BookingDTO> bookingRequests = adminService.viewBookings();
		ResponseEntity<List<BookingDTO>> response = new ResponseEntity<List<BookingDTO>>(bookingRequests, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/accept-request/{bookingId}")
	public ResponseEntity<String> acceptRequest(@PathVariable("bookingId") Integer bookingId) throws BookingException {
		adminService.acceptbookingRequest(bookingId);
		return new ResponseEntity<String>("Flight request with BookingId: "+bookingId+" is ACCEPTED", HttpStatus.OK);
	}
	
	@PutMapping("/reject-request/{bookingId}")
	public ResponseEntity<String> rejectRequest(@PathVariable("bookingId") Integer bookingId) throws BookingException {
		adminService.rejectBookingRequest(bookingId);
		return new ResponseEntity<String>("Flight request with BookingId: "+bookingId+" is REJECTED", HttpStatus.OK);
	}
	
	@GetMapping("/view-offers")
	public ResponseEntity<List<OfferDTO>> viewOffers(){
		return new ResponseEntity<List<OfferDTO>>(adminService.viewOffers(), HttpStatus.OK);
	}
	
	@PostMapping("/add-offer")
	public ResponseEntity<String> addOffer(@RequestBody OfferDTO offer) throws Exception{
		adminService.addOffer(offer);
		return new ResponseEntity<String>("Offer added with title "+offer.getOfferTitle(), HttpStatus.OK);
	}
	
	@PutMapping("/remove-offer/{offerTitle}")
	public ResponseEntity<String> removeOffers(@PathVariable("offerTitle") String offerTitle) throws OfferException{
		adminService.removeOffer(offerTitle);
		return new ResponseEntity<String>("Offer with title "+offerTitle+" is removed", HttpStatus.OK);
	}
	
	@PostMapping("/create-flight")
	public ResponseEntity<String> createFlight(@RequestBody FlightDTO newFlight) throws FlightException {
		adminService.createFlight(newFlight);
		return new ResponseEntity<String>("New Flight is created with FlightNo: "+newFlight.getFlightNo(), HttpStatus.OK);
	}
	
	@GetMapping("/no-of-pending-requests")
	public ResponseEntity<Integer> noOfRequestsPending(){
		return new ResponseEntity<Integer>(adminService.noOfRequestsPending(), HttpStatus.OK);
	}
	
}
