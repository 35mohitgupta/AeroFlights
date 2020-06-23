package com.infy.aeroFlights.validators;

import com.infy.aeroFlights.dto.Gender;
import com.infy.aeroFlights.dto.PassengerDTO;
import com.infy.aeroFlights.exception.PassengerException;

public class PassengerValidation {

	public static void validatePassenger(PassengerDTO passengerDTO) throws PassengerException {
		validateAge(passengerDTO.getAge());
		validateGender(passengerDTO.getGender());
		validateName(passengerDTO.getName());
		
	}
	
	public static void validateAge(Integer age) throws PassengerException {
		if(age == null || age <= 0)
			throw new PassengerException("INVALID_PASSENGER_AGE");
	}
	
	public static void validateGender(Gender gender) throws PassengerException {
		if(gender == null)
			throw new PassengerException("INVALID_PASSENGER_GENDER");
	}
	
	public static void validateName(String name) throws PassengerException {
		if(name == null || name.trim().equals(""))
			throw new PassengerException("INVALID_PASSENGER_NAME");
	}
	
}
