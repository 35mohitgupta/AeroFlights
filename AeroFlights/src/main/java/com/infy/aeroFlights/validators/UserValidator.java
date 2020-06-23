package com.infy.aeroFlights.validators;

import com.infy.aeroFlights.dto.UserDTO;
import com.infy.aeroFlights.exception.UserException;

public class UserValidator {

	public static void validateUser(UserDTO userDTO) throws UserException {
		validateUsername(userDTO.getUsername());
	}
	
	public static void validateUsername(String username) throws UserException {
		if(username == null || username.trim().equalsIgnoreCase(""))
			throw new UserException("INVALID_USERNAME");
	}
}
